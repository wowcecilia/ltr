

/* First created by JCasGen Wed Sep 11 13:44:28 EDT 2013 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



import org.apache.uima.jcas.cas.StringArray;


import org.apache.uima.jcas.cas.StringList;


/** 
 * Updated by JCasGen Sun Oct 06 16:53:40 PDT 2013
 * XML source: /home/psureshk/workspace/hw2-psureshk/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class Question extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Question.class);
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
  protected Question() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Question(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Question(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Question(JCas jcas, int begin, int end) {
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
  //* Feature: Subject

  /** getter for Subject - gets Identifies the Subject in the Question
   * @generated */
  public String getSubject() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_Subject == null)
      jcasType.jcas.throwFeatMissing("Subject", "edu.cmu.deiis.types.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_Subject);}
    
  /** setter for Subject - sets Identifies the Subject in the Question 
   * @generated */
  public void setSubject(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_Subject == null)
      jcasType.jcas.throwFeatMissing("Subject", "edu.cmu.deiis.types.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_Subject, v);}    
   
    
  //*--------------*
  //* Feature: Object

  /** getter for Object - gets Identifies the Object in the question
   * @generated */
  public String getObject() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_Object == null)
      jcasType.jcas.throwFeatMissing("Object", "edu.cmu.deiis.types.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_Object);}
    
  /** setter for Object - sets Identifies the Object in the question 
   * @generated */
  public void setObject(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_Object == null)
      jcasType.jcas.throwFeatMissing("Object", "edu.cmu.deiis.types.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_Object, v);}    
   
    
  //*--------------*
  //* Feature: Verb

  /** getter for Verb - gets Identifies the verb
   * @generated */
  public String getVerb() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_Verb == null)
      jcasType.jcas.throwFeatMissing("Verb", "edu.cmu.deiis.types.Question");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Question_Type)jcasType).casFeatCode_Verb);}
    
  /** setter for Verb - sets Identifies the verb 
   * @generated */
  public void setVerb(String v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_Verb == null)
      jcasType.jcas.throwFeatMissing("Verb", "edu.cmu.deiis.types.Question");
    jcasType.ll_cas.ll_setStringValue(addr, ((Question_Type)jcasType).casFeatCode_Verb, v);}    
  }

    