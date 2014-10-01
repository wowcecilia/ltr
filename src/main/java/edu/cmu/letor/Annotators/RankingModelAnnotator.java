package edu.cmu.letor.Annotators;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import edu.cmu.letor.types.FeatureVector;

public class RankingModelAnnotator extends JCasAnnotator_ImplBase {

  String modelFile = "model/logistic_regression_dummy"; 
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		FeatureVector fv = new FeatureVector(aJCas);
		FSIndex FVIndex = aJCas.getAnnotationIndex(FeatureVector.type);
		Iterator FVIter = FVIndex.iterator();
		LogisticRegression model = LogisticRegression.loadModel(modelFile);
		while (FVIter.hasNext()) {
			fv = (FeatureVector) FVIter.next();
			System.out.println(fv.getFeatureVector());
			float[] input = fv.getFeatureVector().toArray();
			float[] feat = Arrays.copyOfRange(input, 1, input.length - 1);
			float score = model.classify(feat);
			System.out.println("qid:" + fv.getFeatureVector(0) + " score:" + score + " 1:"
					+ fv.getFeatureVector(1) + " 2:" + fv.getFeatureVector(2)
					+ " 3:" + fv.getFeatureVector(3) + " acID:"
					+ fv.getFeatureVector(4));
		}

	}
}
