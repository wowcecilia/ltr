
/* First created by JCasGen Wed Sep 11 13:44:28 EDT 2013 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** 
 * Updated by JCasGen Sun Oct 06 16:53:39 PDT 2013
 * @generated */
public class Answer_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Answer_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Answer_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Answer(addr, Answer_Type.this);
  			   Answer_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Answer(addr, Answer_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Answer.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.deiis.types.Answer");
 
  /** @generated */
  final Feature casFeat_isCorrect;
  /** @generated */
  final int     casFeatCode_isCorrect;
  /** @generated */ 
  public boolean getIsCorrect(int addr) {
        if (featOkTst && casFeat_isCorrect == null)
      jcas.throwFeatMissing("isCorrect", "edu.cmu.deiis.types.Answer");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_isCorrect);
  }
  /** @generated */    
  public void setIsCorrect(int addr, boolean v) {
        if (featOkTst && casFeat_isCorrect == null)
      jcas.throwFeatMissing("isCorrect", "edu.cmu.deiis.types.Answer");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_isCorrect, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Subject;
  /** @generated */
  final int     casFeatCode_Subject;
  /** @generated */ 
  public String getSubject(int addr) {
        if (featOkTst && casFeat_Subject == null)
      jcas.throwFeatMissing("Subject", "edu.cmu.deiis.types.Answer");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Subject);
  }
  /** @generated */    
  public void setSubject(int addr, String v) {
        if (featOkTst && casFeat_Subject == null)
      jcas.throwFeatMissing("Subject", "edu.cmu.deiis.types.Answer");
    ll_cas.ll_setStringValue(addr, casFeatCode_Subject, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Object;
  /** @generated */
  final int     casFeatCode_Object;
  /** @generated */ 
  public String getObject(int addr) {
        if (featOkTst && casFeat_Object == null)
      jcas.throwFeatMissing("Object", "edu.cmu.deiis.types.Answer");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Object);
  }
  /** @generated */    
  public void setObject(int addr, String v) {
        if (featOkTst && casFeat_Object == null)
      jcas.throwFeatMissing("Object", "edu.cmu.deiis.types.Answer");
    ll_cas.ll_setStringValue(addr, casFeatCode_Object, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Verb;
  /** @generated */
  final int     casFeatCode_Verb;
  /** @generated */ 
  public String getVerb(int addr) {
        if (featOkTst && casFeat_Verb == null)
      jcas.throwFeatMissing("Verb", "edu.cmu.deiis.types.Answer");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Verb);
  }
  /** @generated */    
  public void setVerb(int addr, String v) {
        if (featOkTst && casFeat_Verb == null)
      jcas.throwFeatMissing("Verb", "edu.cmu.deiis.types.Answer");
    ll_cas.ll_setStringValue(addr, casFeatCode_Verb, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Agent;
  /** @generated */
  final int     casFeatCode_Agent;
  /** @generated */ 
  public String getAgent(int addr) {
        if (featOkTst && casFeat_Agent == null)
      jcas.throwFeatMissing("Agent", "edu.cmu.deiis.types.Answer");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Agent);
  }
  /** @generated */    
  public void setAgent(int addr, String v) {
        if (featOkTst && casFeat_Agent == null)
      jcas.throwFeatMissing("Agent", "edu.cmu.deiis.types.Answer");
    ll_cas.ll_setStringValue(addr, casFeatCode_Agent, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Negative;
  /** @generated */
  final int     casFeatCode_Negative;
  /** @generated */ 
  public String getNegative(int addr) {
        if (featOkTst && casFeat_Negative == null)
      jcas.throwFeatMissing("Negative", "edu.cmu.deiis.types.Answer");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Negative);
  }
  /** @generated */    
  public void setNegative(int addr, String v) {
        if (featOkTst && casFeat_Negative == null)
      jcas.throwFeatMissing("Negative", "edu.cmu.deiis.types.Answer");
    ll_cas.ll_setStringValue(addr, casFeatCode_Negative, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Score;
  /** @generated */
  final int     casFeatCode_Score;
  /** @generated */ 
  public float getScore(int addr) {
        if (featOkTst && casFeat_Score == null)
      jcas.throwFeatMissing("Score", "edu.cmu.deiis.types.Answer");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_Score);
  }
  /** @generated */    
  public void setScore(int addr, float v) {
        if (featOkTst && casFeat_Score == null)
      jcas.throwFeatMissing("Score", "edu.cmu.deiis.types.Answer");
    ll_cas.ll_setFloatValue(addr, casFeatCode_Score, v);}
    
  
 
  /** @generated */
  final Feature casFeat_AnswerOldPosition;
  /** @generated */
  final int     casFeatCode_AnswerOldPosition;
  /** @generated */ 
  public int getAnswerOldPosition(int addr) {
        if (featOkTst && casFeat_AnswerOldPosition == null)
      jcas.throwFeatMissing("AnswerOldPosition", "edu.cmu.deiis.types.Answer");
    return ll_cas.ll_getIntValue(addr, casFeatCode_AnswerOldPosition);
  }
  /** @generated */    
  public void setAnswerOldPosition(int addr, int v) {
        if (featOkTst && casFeat_AnswerOldPosition == null)
      jcas.throwFeatMissing("AnswerOldPosition", "edu.cmu.deiis.types.Answer");
    ll_cas.ll_setIntValue(addr, casFeatCode_AnswerOldPosition, v);}
    
  
 
  /** @generated */
  final Feature casFeat_AnswerConfidence;
  /** @generated */
  final int     casFeatCode_AnswerConfidence;
  /** @generated */ 
  public float getAnswerConfidence(int addr) {
        if (featOkTst && casFeat_AnswerConfidence == null)
      jcas.throwFeatMissing("AnswerConfidence", "edu.cmu.deiis.types.Answer");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_AnswerConfidence);
  }
  /** @generated */    
  public void setAnswerConfidence(int addr, float v) {
        if (featOkTst && casFeat_AnswerConfidence == null)
      jcas.throwFeatMissing("AnswerConfidence", "edu.cmu.deiis.types.Answer");
    ll_cas.ll_setFloatValue(addr, casFeatCode_AnswerConfidence, v);}
    
  
 
  /** @generated */
  final Feature casFeat_dummy;
  /** @generated */
  final int     casFeatCode_dummy;
  /** @generated */ 
  public int getDummy(int addr) {
        if (featOkTst && casFeat_dummy == null)
      jcas.throwFeatMissing("dummy", "edu.cmu.deiis.types.Answer");
    return ll_cas.ll_getIntValue(addr, casFeatCode_dummy);
  }
  /** @generated */    
  public void setDummy(int addr, int v) {
        if (featOkTst && casFeat_dummy == null)
      jcas.throwFeatMissing("dummy", "edu.cmu.deiis.types.Answer");
    ll_cas.ll_setIntValue(addr, casFeatCode_dummy, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Answer_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_isCorrect = jcas.getRequiredFeatureDE(casType, "isCorrect", "uima.cas.Boolean", featOkTst);
    casFeatCode_isCorrect  = (null == casFeat_isCorrect) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_isCorrect).getCode();

 
    casFeat_Subject = jcas.getRequiredFeatureDE(casType, "Subject", "uima.cas.String", featOkTst);
    casFeatCode_Subject  = (null == casFeat_Subject) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Subject).getCode();

 
    casFeat_Object = jcas.getRequiredFeatureDE(casType, "Object", "uima.cas.String", featOkTst);
    casFeatCode_Object  = (null == casFeat_Object) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Object).getCode();

 
    casFeat_Verb = jcas.getRequiredFeatureDE(casType, "Verb", "uima.cas.String", featOkTst);
    casFeatCode_Verb  = (null == casFeat_Verb) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Verb).getCode();

 
    casFeat_Agent = jcas.getRequiredFeatureDE(casType, "Agent", "uima.cas.String", featOkTst);
    casFeatCode_Agent  = (null == casFeat_Agent) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Agent).getCode();

 
    casFeat_Negative = jcas.getRequiredFeatureDE(casType, "Negative", "uima.cas.String", featOkTst);
    casFeatCode_Negative  = (null == casFeat_Negative) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Negative).getCode();

 
    casFeat_Score = jcas.getRequiredFeatureDE(casType, "Score", "uima.cas.Float", featOkTst);
    casFeatCode_Score  = (null == casFeat_Score) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Score).getCode();

 
    casFeat_AnswerOldPosition = jcas.getRequiredFeatureDE(casType, "AnswerOldPosition", "uima.cas.Integer", featOkTst);
    casFeatCode_AnswerOldPosition  = (null == casFeat_AnswerOldPosition) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_AnswerOldPosition).getCode();

 
    casFeat_AnswerConfidence = jcas.getRequiredFeatureDE(casType, "AnswerConfidence", "uima.cas.Float", featOkTst);
    casFeatCode_AnswerConfidence  = (null == casFeat_AnswerConfidence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_AnswerConfidence).getCode();

 
    casFeat_dummy = jcas.getRequiredFeatureDE(casType, "dummy", "uima.cas.Integer", featOkTst);
    casFeatCode_dummy  = (null == casFeat_dummy) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_dummy).getCode();

  }
}



    