

/* First created by JCasGen Tue Sep 23 14:14:57 EDT 2014 */
package edu.cmu.letor.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FloatArray;


import org.apache.uima.jcas.cas.FloatList;


/** Type to store the feature vector obtained from parsing the Question and Answer
 * Updated by JCasGen Wed Sep 24 12:19:21 EDT 2014
 * XML source: /Users/psureshk/Documents/Fall'14/hw2-psureshk/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class FeatureVector extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(FeatureVector.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected FeatureVector() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public FeatureVector(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public FeatureVector(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public FeatureVector(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: FeatureVector

  /** getter for FeatureVector - gets To store the features in a line format
   * @generated
   * @return value of the feature 
   */
  public FloatArray getFeatureVector() {
    if (FeatureVector_Type.featOkTst && ((FeatureVector_Type)jcasType).casFeat_FeatureVector == null)
      jcasType.jcas.throwFeatMissing("FeatureVector", "edu.cmu.deiis.types.FeatureVector");
    return (FloatArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((FeatureVector_Type)jcasType).casFeatCode_FeatureVector)));}
    
  /** setter for FeatureVector - sets To store the features in a line format 
   * @generated
   * @param v value to set into the feature 
   */
  public void setFeatureVector(FloatArray v) {
    if (FeatureVector_Type.featOkTst && ((FeatureVector_Type)jcasType).casFeat_FeatureVector == null)
      jcasType.jcas.throwFeatMissing("FeatureVector", "edu.cmu.deiis.types.FeatureVector");
    jcasType.ll_cas.ll_setRefValue(addr, ((FeatureVector_Type)jcasType).casFeatCode_FeatureVector, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for FeatureVector - gets an indexed value - To store the features in a line format
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public float getFeatureVector(int i) {
    if (FeatureVector_Type.featOkTst && ((FeatureVector_Type)jcasType).casFeat_FeatureVector == null)
      jcasType.jcas.throwFeatMissing("FeatureVector", "edu.cmu.deiis.types.FeatureVector");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((FeatureVector_Type)jcasType).casFeatCode_FeatureVector), i);
    return jcasType.ll_cas.ll_getFloatArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((FeatureVector_Type)jcasType).casFeatCode_FeatureVector), i);}

  /** indexed setter for FeatureVector - sets an indexed value - To store the features in a line format
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setFeatureVector(int i, float v) { 
    if (FeatureVector_Type.featOkTst && ((FeatureVector_Type)jcasType).casFeat_FeatureVector == null)
      jcasType.jcas.throwFeatMissing("FeatureVector", "edu.cmu.deiis.types.FeatureVector");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((FeatureVector_Type)jcasType).casFeatCode_FeatureVector), i);
    jcasType.ll_cas.ll_setFloatArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((FeatureVector_Type)jcasType).casFeatCode_FeatureVector), i, v);}
  }

    