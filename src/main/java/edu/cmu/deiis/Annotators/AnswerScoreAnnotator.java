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
   for(int i = 0; i< al.size();i++)
    {
      String[] arr = lines[al.get(i).getAnswerOldPosition()].split(" ", 3);
      if(al.get(i).getIsCorrect())
        System.out.println("+ "+al.get(i).getScore() +" " + arr[2]);
      else
        System.out.println("- "+al.get(i).getScore() +" " + arr[2]);
    }
  }
}

class AnswerComparator implements Comparator<Answer>
{
  @Override
  public int compare(Answer a1, Answer a2) {
    //return o1.getScore() - o2.getScore();
    if(a1.getScore()> a2.getScore())
      return 1;
    else if(a1.getScore() < a2.getScore())
      return -1;
    else
      return 0;
      
  }
  
}
