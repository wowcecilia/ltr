

/* First created by JCasGen Wed Sep 11 13:44:28 EDT 2013 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



import org.apache.uima.jcas.cas.FSArray;


import org.apache.uima.jcas.cas.BooleanArray;


/** 
 * Updated by JCasGen Sun Oct 06 16:53:39 PDT 2013
 * XML source: /home/psureshk/workspace/hw2-psureshk/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class Answer extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Answer.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Answer() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Answer(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Answer(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Answer(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: isCorrect

  /** getter for isCorrect - gets 
   * @generated */
  public boolean getIsCorrect() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_isCorrect == null)
      jcasType.jcas.throwFeatMissing("isCorrect", "edu.cmu.deiis.types.Answer");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((Answer_Type)jcasType).casFeatCode_isCorrect);}
    
  /** setter for isCorrect - sets  
   * @generated */
  public void setIsCorrect(boolean v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_isCorrect == null)
      jcasType.jcas.throwFeatMissing("isCorrect", "edu.cmu.deiis.types.Answer");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((Answer_Type)jcasType).casFeatCode_isCorrect, v);}    
   
    
  //*--------------*
  //* Feature: Subject

  /** getter for Subject - gets 
   * @generated */
  public String getSubject() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_Subject == null)
      jcasType.jcas.throwFeatMissing("Subject", "edu.cmu.deiis.types.Answer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Answer_Type)jcasType).casFeatCode_Subject);}
    
  /** setter for Subject - sets  
   * @generated */
  public void setSubject(String v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_Subject == null)
      jcasType.jcas.throwFeatMissing("Subject", "edu.cmu.deiis.types.Answer");
    jcasType.ll_cas.ll_setStringValue(addr, ((Answer_Type)jcasType).casFeatCode_Subject, v);}    
   
    
  //*--------------*
  //* Feature: Object

  /** getter for Object - gets 
   * @generated */
  public String getObject() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_Object == null)
      jcasType.jcas.throwFeatMissing("Object", "edu.cmu.deiis.types.Answer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Answer_Type)jcasType).casFeatCode_Object);}
    
  /** setter for Object - sets  
   * @generated */
  public void setObject(String v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_Object == null)
      jcasType.jcas.throwFeatMissing("Object", "edu.cmu.deiis.types.Answer");
    jcasType.ll_cas.ll_setStringValue(addr, ((Answer_Type)jcasType).casFeatCode_Object, v);}    
   
    
  //*--------------*
  //* Feature: Verb

  /** getter for Verb - gets 
   * @generated */
  public String getVerb() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_Verb == null)
      jcasType.jcas.throwFeatMissing("Verb", "edu.cmu.deiis.types.Answer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Answer_Type)jcasType).casFeatCode_Verb);}
    
  /** setter for Verb - sets  
   * @generated */
  public void setVerb(String v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_Verb == null)
      jcasType.jcas.throwFeatMissing("Verb", "edu.cmu.deiis.types.Answer");
    jcasType.ll_cas.ll_setStringValue(addr, ((Answer_Type)jcasType).casFeatCode_Verb, v);}    
   
    
  //*--------------*
  //* Feature: Agent

  /** getter for Agent - gets 
   * @generated */
  public String getAgent() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_Agent == null)
      jcasType.jcas.throwFeatMissing("Agent", "edu.cmu.deiis.types.Answer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Answer_Type)jcasType).casFeatCode_Agent);}
    
  /** setter for Agent - sets  
   * @generated */
  public void setAgent(String v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_Agent == null)
      jcasType.jcas.throwFeatMissing("Agent", "edu.cmu.deiis.types.Answer");
    jcasType.ll_cas.ll_setStringValue(addr, ((Answer_Type)jcasType).casFeatCode_Agent, v);}    
   
    
  //*--------------*
  //* Feature: Negative

  /** getter for Negative - gets 
   * @generated */
  public String getNegative() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_Negative == null)
      jcasType.jcas.throwFeatMissing("Negative", "edu.cmu.deiis.types.Answer");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Answer_Type)jcasType).casFeatCode_Negative);}
    
  /** setter for Negative - sets  
   * @generated */
  public void setNegative(String v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_Negative == null)
      jcasType.jcas.throwFeatMissing("Negative", "edu.cmu.deiis.types.Answer");
    jcasType.ll_cas.ll_setStringValue(addr, ((Answer_Type)jcasType).casFeatCode_Negative, v);}    
   
    
  //*--------------*
  //* Feature: Score

  /** getter for Score - gets 
   * @generated */
  public float getScore() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_Score == null)
      jcasType.jcas.throwFeatMissing("Score", "edu.cmu.deiis.types.Answer");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Answer_Type)jcasType).casFeatCode_Score);}
    
  /** setter for Score - sets  
   * @generated */
  public void setScore(float v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_Score == null)
      jcasType.jcas.throwFeatMissing("Score", "edu.cmu.deiis.types.Answer");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Answer_Type)jcasType).casFeatCode_Score, v);}    
   
    
  //*--------------*
  //* Feature: AnswerOldPosition

  /** getter for AnswerOldPosition - gets 
   * @generated */
  public int getAnswerOldPosition() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_AnswerOldPosition == null)
      jcasType.jcas.throwFeatMissing("AnswerOldPosition", "edu.cmu.deiis.types.Answer");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Answer_Type)jcasType).casFeatCode_AnswerOldPosition);}
    
  /** setter for AnswerOldPosition - sets  
   * @generated */
  public void setAnswerOldPosition(int v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_AnswerOldPosition == null)
      jcasType.jcas.throwFeatMissing("AnswerOldPosition", "edu.cmu.deiis.types.Answer");
    jcasType.ll_cas.ll_setIntValue(addr, ((Answer_Type)jcasType).casFeatCode_AnswerOldPosition, v);}    
   
    
  //*--------------*
  //* Feature: AnswerConfidence

  /** getter for AnswerConfidence - gets 
   * @generated */
  public float getAnswerConfidence() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_AnswerConfidence == null)
      jcasType.jcas.throwFeatMissing("AnswerConfidence", "edu.cmu.deiis.types.Answer");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Answer_Type)jcasType).casFeatCode_AnswerConfidence);}
    
  /** setter for AnswerConfidence - sets  
   * @generated */
  public void setAnswerConfidence(float v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_AnswerConfidence == null)
      jcasType.jcas.throwFeatMissing("AnswerConfidence", "edu.cmu.deiis.types.Answer");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Answer_Type)jcasType).casFeatCode_AnswerConfidence, v);}    
   
    
  //*--------------*
  //* Feature: dummy

  /** getter for dummy - gets 
   * @generated */
  public int getDummy() {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_dummy == null)
      jcasType.jcas.throwFeatMissing("dummy", "edu.cmu.deiis.types.Answer");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Answer_Type)jcasType).casFeatCode_dummy);}
    
  /** setter for dummy - sets  
   * @generated */
  public void setDummy(int v) {
    if (Answer_Type.featOkTst && ((Answer_Type)jcasType).casFeat_dummy == null)
      jcasType.jcas.throwFeatMissing("dummy", "edu.cmu.deiis.types.Answer");
    jcasType.ll_cas.ll_setIntValue(addr, ((Answer_Type)jcasType).casFeatCode_dummy, v);}    
  }

    