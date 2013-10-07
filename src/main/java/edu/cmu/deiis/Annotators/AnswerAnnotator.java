package edu.cmu.deiis.Annotators;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import edu.cmu.deiis.types.Answer;
import edu.cmu.deiis.types.Question;
import edu.stanford.nlp.dcoref.CorefChain;
import edu.stanford.nlp.dcoref.CorefCoreAnnotations.CorefChainAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;

public class AnswerAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {

    String QSubject = "";
    String QObject = "";
    String QVerb = "";
    Question qa = new Question(aJCas);
    FSIndex QIndex = aJCas.getAnnotationIndex(Question.type);
    Iterator QIter = QIndex.iterator();
    while (QIter.hasNext()) {
      qa = (Question) QIter.next();
      // do something
      QSubject = qa.getSubject();
      QObject = qa.getObject();
      QVerb = qa.getVerb();
    }
    // TODO Auto-generated method stub
    String docText = aJCas.getDocumentText();
    String lines[] = docText.split(System.getProperty("line.separator"));
    System.out.println("Lines: " + lines.length);
    for (int linein = 1; linein < lines.length; linein++) {
      Properties props = new Properties();
      props.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
      StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

      String text = lines[linein];
      String[] arr = text.split(" ", 3);
      Annotation document = new Annotation(arr[2]);
      pipeline.annotate(document);
      int answerwordcount = arr[2].trim().split("\\s+").length;
      Answer aa = new Answer(aJCas);
      List<CoreMap> sentences = document.get(SentencesAnnotation.class);
      String lemmaverb = "";
      for (CoreMap sentence : sentences) {
        for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
          String word = token.get(TextAnnotation.class);
   
          String pos = token.get(PartOfSpeechAnnotation.class);
      
          if (pos.contains("VB")) {
            lemmaverb = token.get(LemmaAnnotation.class);
        
          }
          String ne = token.get(NamedEntityTagAnnotation.class);
          
        }

        Tree tree = sentence.get(TreeAnnotation.class);
        

        // this is the Stanford dependency graph of the current sentence
        SemanticGraph dependencies = sentence.get(CollapsedCCProcessedDependenciesAnnotation.class);
        String dep[] = dependencies.toString().split(System.getProperty("line.separator"));
        String Subject = "";
        String Object = "";
        String Verb = "";
        String Agent = null;
        String Negative = null;
        for (int i = 0; i < dep.length; i++) {
          if (dep[i].contains("subj")) {
            String word[] = dep[i].split("[ -]");
            aa.setSubject(word[4]);
            Subject = word[4];
          } else if (dep[i].contains("obj")) {
            String word[] = dep[i].split("[ -]");
            aa.setObject(word[4]);
            Object = word[4];
          } else if (dep[i].contains("neg")) {
            String word[] = dep[i].split("[ -]");
            aa.setNegative(word[4]);
            Negative = word[4];
          } else if (dep[i].contains("agent")) {
            String word[] = dep[i].split("[ -]");
            aa.setAgent(word[4]);
            Agent = word[4];
          }else if (dep[i].contains("root")) {
            String word[] = dep[i].split("[ -]");
            aa.setVerb(word[2]);
            Verb = word[2];
        }
        }
        
        /* Calculate the score and confidence */
        aa.setIsCorrect(true);
        int match = 0;
        double score = 1.0;
        if (Agent != null) { //Passive voice
          if (QSubject.equals(Agent)) {
            match++;
          } 
          if (QObject.equals(Subject)) {
            match++;
          } 
          if(match==2 && Negative!=null)
            aa.setIsCorrect(false);
          if (QVerb.equals(Verb)) {
            if(match!=2){
              aa.setIsCorrect(false);
            }
            match++;
          } else {
            if (IsSynonym(QVerb, Verb)) {
              if(match!=2)
                aa.setIsCorrect(false);
              score -= 0.1; // if the verbs are synonyms then score reduction for cost of analysing
            } else {
              score -= 0.2;
              aa.setIsCorrect(false);
            }
          }
        }
           else {
          if (QSubject.equals(Subject)) {
            match++;
          } 
          if (QObject.equals(Object)) {
            match++;
          } 
          if(match==2 && Negative!=null)
            aa.setIsCorrect(false);
          if (QVerb.equals(Verb)) {
            if(match!=2)
              aa.setIsCorrect(false);
            match++;
            } else {
            if (IsSynonym(QVerb, Verb)) {
              if(match!=2)
                aa.setIsCorrect(false);
              score -= 0.1; // if the verbs are synonyms then score reduction for cost of analysing
            } else {
              score -= 0.2;
              aa.setIsCorrect(false);
            }

          }
        }
        double confidence;
        if(match==3)
        {
          if(Negative!=null)
          {
            aa.setIsCorrect(false);
            score-=0.15;
          }
          else
            aa.setIsCorrect(true);
        }
        if(match==0)
          aa.setIsCorrect(false);
        score-= (answerwordcount-match) * 0.05;
        confidence = 100/(4-match);
        aa.setAnswerConfidence((float) confidence);
        aa.setScore((float)score);
        aa.setAnswerOldPosition(linein);
        aa.setDummy(1);
        aa.addToIndexes();
      }

      // This is the coreference link graph
      // Each chain stores a set of mentions that link to each other,
      // along with a method for getting the most representative mention
      // Both sentence and token offsets start at 1!
      Map<Integer, CorefChain> graph = document.get(CorefChainAnnotation.class);
    }
  }

  private boolean IsSynonym(String qVerb, String verb) {
    // TODO Auto-generated method stub
    return true;
  }
}
