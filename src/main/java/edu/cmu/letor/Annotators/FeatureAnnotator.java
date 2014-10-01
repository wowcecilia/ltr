package edu.cmu.letor.Annotators;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FloatArray;

import edu.cmu.letor.types.Answer;
import edu.cmu.letor.types.FeatureVector;
import edu.cmu.letor.types.Question;

public class FeatureAnnotator extends JCasAnnotator_ImplBase {

	@SuppressWarnings("unused")
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		String QSubject = "";
		String QObject = "";
		String QVerb = "";
		String ASubject = "";
		String AObject = "";
		String AVerb = "";
		int qID = 1;
		int acID = 1;
		Question qa = new Question(aJCas);
		FSIndex QIndex = aJCas.getAnnotationIndex(Question.type);
		Iterator QIter = QIndex.iterator();
		while (QIter.hasNext()) {
			qa = (Question) QIter.next();
			// do something
			QSubject = qa.getSubject();
			QObject = qa.getObject();
			QVerb = qa.getVerb();
			Answer aa = new Answer(aJCas);
			FSIndex AIndex = aJCas.getAnnotationIndex(Answer.type);
			Iterator AIter = AIndex.iterator();
			while (AIter.hasNext()) {
				FeatureVector fv = new FeatureVector(aJCas);
				fv.setFeatureVector(new FloatArray(aJCas, 5));
				fv.setFeatureVector(0, qID);
				
				aa = (Answer) AIter.next();
				ASubject = aa.getSubject();
				AObject = aa.getObject();
				AVerb = aa.getVerb();
				if (QSubject.equals(ASubject)) {
					fv.setFeatureVector(1, 1);
				} else {
					fv.setFeatureVector(1, 0);
				}
				
				if (QObject.equals(AObject)) {
					fv.setFeatureVector(2, 1);
				} else {
					fv.setFeatureVector(2, 0);
				}
				
				if (QVerb.equals(AVerb)) {
					fv.setFeatureVector(3, 1);
				} else {
					fv.setFeatureVector(3, 0);
				}
				
				fv.setFeatureVector(4, acID);
				
				acID++;
				fv.addToIndexes();
				System.out.println(fv.getFeatureVector());
			}
			qID++;
			acID = 1;
		}

	}

}
