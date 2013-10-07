
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
 * Updated by JCasGen Sun Oct 06 16:53:40 PDT 2013
 * @generated */
public class Question_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Question_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Question_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Question(addr, Question_Type.this);
  			   Question_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Question(addr, Question_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Question.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.deiis.types.Question");



  /** @generated */
  final Feature casFeat_Subject;
  /** @generated */
  final int     casFeatCode_Subject;
  /** @generated */ 
  public String getSubject(int addr) {
        if (featOkTst && casFeat_Subject == null)
      jcas.throwFeatMissing("Subject", "edu.cmu.deiis.types.Question");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Subject);
  }
  /** @generated */    
  public void setSubject(int addr, String v) {
        if (featOkTst && casFeat_Subject == null)
      jcas.throwFeatMissing("Subject", "edu.cmu.deiis.types.Question");
    ll_cas.ll_setStringValue(addr, casFeatCode_Subject, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Object;
  /** @generated */
  final int     casFeatCode_Object;
  /** @generated */ 
  public String getObject(int addr) {
        if (featOkTst && casFeat_Object == null)
      jcas.throwFeatMissing("Object", "edu.cmu.deiis.types.Question");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Object);
  }
  /** @generated */    
  public void setObject(int addr, String v) {
        if (featOkTst && casFeat_Object == null)
      jcas.throwFeatMissing("Object", "edu.cmu.deiis.types.Question");
    ll_cas.ll_setStringValue(addr, casFeatCode_Object, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Verb;
  /** @generated */
  final int     casFeatCode_Verb;
  /** @generated */ 
  public String getVerb(int addr) {
        if (featOkTst && casFeat_Verb == null)
      jcas.throwFeatMissing("Verb", "edu.cmu.deiis.types.Question");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Verb);
  }
  /** @generated */    
  public void setVerb(int addr, String v) {
        if (featOkTst && casFeat_Verb == null)
      jcas.throwFeatMissing("Verb", "edu.cmu.deiis.types.Question");
    ll_cas.ll_setStringValue(addr, casFeatCode_Verb, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Question_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Subject = jcas.getRequiredFeatureDE(casType, "Subject", "uima.cas.String", featOkTst);
    casFeatCode_Subject  = (null == casFeat_Subject) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Subject).getCode();

 
    casFeat_Object = jcas.getRequiredFeatureDE(casType, "Object", "uima.cas.String", featOkTst);
    casFeatCode_Object  = (null == casFeat_Object) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Object).getCode();

 
    casFeat_Verb = jcas.getRequiredFeatureDE(casType, "Verb", "uima.cas.String", featOkTst);
    casFeatCode_Verb  = (null == casFeat_Verb) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Verb).getCode();

  }
}



    