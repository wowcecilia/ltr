package edu.cmu.deiis.Annotators;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import edu.cmu.deiis.types.Answer;

public class AnswerScoreAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub

    String docText = aJCas.getDocumentText();
    String lines[] = docText.split(System.getProperty("line.separator"));
    double max = 0.0;
    Answer aa = new Answer(aJCas);
    FSIndex AIndex = aJCas.getAnnotationIndex(Answer.type);
    Iterator AIter = AIndex.iterator();
    ArrayList<Answer> al = new ArrayList<Answer>();
    for(int i=0;i<AIndex.size();i++){
      FSIndex AIndex1 = aJCas.getAnnotationIndex(Answer.type);
      Iterator AIter1 = AIndex1.iterator();
    while (AIter1.hasNext()) {
      Answer aa1 = (Answer) AIter1.next();
      if(aa1.getScore()>max && aa1.getDummy()!=-1)
      {
         aa = aa1;
         max = aa1.getScore();
      }
    }
    al.add(aa);
    aa.setDummy(-1);
    aa = new Answer(aJCas);
    max = 0.0;
    }
    //Collections.sort(al,Collections.reverseOrder(new AnswerComparator()));
    /*To print output*/
    int correct = 0;
    for (int i = 0; i < al.size(); i++) {
      String[] arr = lines[al.get(i).getAnswerOldPosition()].split(" ", 3);
      if (al.get(i).getIsCorrect()) {
        System.out.println("+ " + al.get(i).getScore() + " " + arr[2]);
        if (arr[1].equals("1"))
          correct++;
      } else {
        System.out.println("- " + al.get(i).getScore() + " " + arr[2]);
        if (arr[1].equals("0"))
          correct++;
      }
    }
    int accuracy = correct/(lines.length-1);
    System.out.println("Accuracy at : "+accuracy); 
  }
}