package edu.cmu.letor.Annotators;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.lang.Object;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.letor.types.Question;
import edu.stanford.nlp.dcoref.CorefChain;
import edu.stanford.nlp.dcoref.CorefCoreAnnotations.CorefChainAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.util.CoreMap;

public class QuestionAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    String docText = aJCas.getDocumentText();
    String lines[] = docText.split(System.getProperty("line.separator"));
    
    
    Properties props = new Properties();
    props.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

    // read some text in the text variable
    String text = lines[0];// Add your text here!

    // create an empty Annotation just with the given text
    Annotation document = new Annotation(text);

    // run all Annotators on this text
    pipeline.annotate(document);

    Question qa = new Question(aJCas);
    // these are all the sentences in this document
    // a CoreMap is essentially a Map that uses class objects as keys and has values with custom
    // types
    List<CoreMap> sentences = document.get(SentencesAnnotation.class);
    String lemmaverb = "";
    for (CoreMap sentence : sentences) {
      // traversing the words in the current sentence
      // a CoreLabel is a CoreMap with additional token-specific methods
      for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
        // this is the text of the token
        String word = token.get(TextAnnotation.class);
        // this is the POS tag of the token
        String pos = token.get(PartOfSpeechAnnotation.class);
        if (pos.contains("VB")) {
          lemmaverb = token.get(LemmaAnnotation.class);
        }
        // this is the NER label of the token
        String ne = token.get(NamedEntityTagAnnotation.class);
      }

      // this is the parse tree of the current sentence
      Tree tree = sentence.get(TreeAnnotation.class);
     

      // this is the Stanford dependency graph of the current sentence
      SemanticGraph dependencies = sentence.get(CollapsedCCProcessedDependenciesAnnotation.class);
      String dep[] = dependencies.toString().split(System.getProperty("line.separator"));
      for (int i = 0; i < dep.length; i++) {
        if (dep[i].contains("subj")) {
          String word[] = dep[i].split("[ -]");
          qa.setSubject(word[4]);
          //qa.addToIndexes();
        } else if (dep[i].contains("obj")) {
          String word[] = dep[i].split("[ -]");
          qa.setObject(word[4]);
          //qa.addToIndexes();
        } else if (dep[i].contains("root")) {
          String word[] = dep[i].split("[ -]");
          qa.setVerb(word[2]);
         
        }

      }
     
     qa.addToIndexes();
    }

  }

}
