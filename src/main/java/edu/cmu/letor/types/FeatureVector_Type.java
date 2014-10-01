
/* First created by JCasGen Tue Sep 23 14:14:57 EDT 2014 */
package edu.cmu.letor.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** Type to store the feature vector obtained from parsing the Question and Answer
 * Updated by JCasGen Wed Sep 24 12:19:21 EDT 2014
 * @generated */
public class FeatureVector_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (FeatureVector_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = FeatureVector_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new FeatureVector(addr, FeatureVector_Type.this);
  			   FeatureVector_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new FeatureVector(addr, FeatureVector_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = FeatureVector.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.deiis.types.FeatureVector");
 
  /** @generated */
  final Feature casFeat_FeatureVector;
  /** @generated */
  final int     casFeatCode_FeatureVector;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getFeatureVector(int addr) {
        if (featOkTst && casFeat_FeatureVector == null)
      jcas.throwFeatMissing("FeatureVector", "edu.cmu.deiis.types.FeatureVector");
    return ll_cas.ll_getRefValue(addr, casFeatCode_FeatureVector);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFeatureVector(int addr, int v) {
        if (featOkTst && casFeat_FeatureVector == null)
      jcas.throwFeatMissing("FeatureVector", "edu.cmu.deiis.types.FeatureVector");
    ll_cas.ll_setRefValue(addr, casFeatCode_FeatureVector, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public float getFeatureVector(int addr, int i) {
        if (featOkTst && casFeat_FeatureVector == null)
      jcas.throwFeatMissing("FeatureVector", "edu.cmu.deiis.types.FeatureVector");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getFloatArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_FeatureVector), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_FeatureVector), i);
  return ll_cas.ll_getFloatArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_FeatureVector), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setFeatureVector(int addr, int i, float v) {
        if (featOkTst && casFeat_FeatureVector == null)
      jcas.throwFeatMissing("FeatureVector", "edu.cmu.deiis.types.FeatureVector");
    if (lowLevelTypeChecks)
      ll_cas.ll_setFloatArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_FeatureVector), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_FeatureVector), i);
    ll_cas.ll_setFloatArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_FeatureVector), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public FeatureVector_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_FeatureVector = jcas.getRequiredFeatureDE(casType, "FeatureVector", "uima.cas.FloatArray", featOkTst);
    casFeatCode_FeatureVector  = (null == casFeat_FeatureVector) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_FeatureVector).getCode();

  }
}



    