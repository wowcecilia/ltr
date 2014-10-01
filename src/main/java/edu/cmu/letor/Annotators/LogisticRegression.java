package edu.cmu.letor.Annotators;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class LogisticRegression {
  float[] model;
  float[][] train_X;
  int[] train_y;
  float learningRate = 0.0001f;
  float C = 0.01f;
  float epsilon = 0.001f;
  float maxIter = 500;
  float bias = 0;

  // List<Integer> shuffle;

  public LogisticRegression(int length, List<Float[]> data, List<Integer> y) {
    model = new float[length];
    train_X = new float[data.size()][];
    train_y = new int[data.size()];

    float[] temp = new float[length]; // unormalized vector
    for (int i = 0; i < data.size(); ++i) {
      Arrays.fill(temp, 0);
      Float x[] = data.get(i);
      for (int j = 0; j < x.length; ++j) {
        temp[j] = x[j] == null ? 0 : x[j];
      }
      train_X[i] = normalize(temp);
      train_y[i] = y.get(i);
    }
  }

  public LogisticRegression epsilon(float epsilon) {
    this.epsilon = epsilon;
    return this;
  }

  public LogisticRegression learningRate(float alpha) {
    this.learningRate = alpha;
    return this;
  }

  public LogisticRegression C(float C) {
    this.C = C;
    return this;
  }
  
  public LogisticRegression(int length) {
    model = new float[length];
  }

  public static LogisticRegression loadModel(String modelFile) {
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(modelFile)));
      String line = br.readLine();
      
      String[] ss = line.split("\\s");
      LogisticRegression ret = new LogisticRegression(ss.length - 1);
      ret.bias = Float.valueOf(ss[0].trim());
      
      for (int i = 0; i < ss.length - 1; ++i) {
        ret.model[i] = Float.valueOf(ss[i + 1].trim());
        ++i;
      }
      br.close();
      return ret;
    } catch (IOException e){
      e.printStackTrace();
      System.exit(1);
    }
    return null;
  }
  
  public String saveModel() {
    StringBuffer sb = new StringBuffer();
    sb.append(bias);
    for (int i = 0; i < model.length; ++i) {
      sb.append('\t');
      sb.append(model[i]);
    }
    return sb.toString();
  }

  public static void main(String args[]) throws IOException {
    if (args.length == 0) {
      System.err
          .println("Usage: java LogisticRegression DATA.txt [-rate learning-rate -epsilon epsilon]");
      System.exit(1);
    }
    // default value of paramter
    float learningRate = 0.0001f;
    float convergenceThreshold = 0.001f;
    int start = 1;
    Properties prop = new Properties();
    prop.load(new FileInputStream(args[0]));
    float C = new Float(prop.getProperty("C", "0.01"));
    while (start < args.length) {
      if (args[start].equals("-rate")) {
        learningRate = new Float(args[++start]);
        start++;
      } else if (args[start].equals("-epsilon")) {
        convergenceThreshold = new Float(args[++start]);
        start++;
      } else if (args[start].equals("-C")) {
        C = new Float(args[++start]);
        start++;
      } else {
        start++;
      }
    }

    String trainFile = prop.getProperty("train");
    String testFile = prop.getProperty("test");
    if (trainFile == null || testFile == null) {
      System.err.println("train and test path must be specified");
      System.exit(1);
    }

    System.err.println(String.format(
        "Parameters: C = %.4f, learningRate = %.4f, "
            + "convergenceThreshold = %.4f\ntrain = %s\ntest = %s", C,
        learningRate, convergenceThreshold, trainFile, testFile));

    List<Float[]> raw = new ArrayList<Float[]>();
    List<Integer> y = new ArrayList<Integer>();
    int length = loadTrainData(trainFile, raw, y);

    LogisticRegression lr = new LogisticRegression(length, raw, y);
    // for (float[] xx: lr.train_X) {
    // System.err.println(Arrays.toString(xx));
    // }
    lr.learningRate(learningRate).epsilon(convergenceThreshold).C(C);
    lr.train();

    List<Float[]> test_x = new ArrayList<Float[]>();
    List<Integer> test_y = new ArrayList<Integer>();
    loadTestData(testFile, test_x, test_y);
    int correct = 0;
    int total = 0;
    float[] temp_x = new float[length];
    float max = 0;
    for (int i = 0; i < test_x.size(); ++i) {
      Arrays.fill(temp_x, 0);
      for (int j = 0; j < length; ++j) {
        temp_x[j] = test_x.get(i)[j];
      }

      float predict = lr.classify(normalize(temp_x));
      System.out.println(predict);
      if (predict >= 0.5 && test_y.get(i) == 1) {
        correct++;
      } else if (predict < 0.5 && test_y.get(i) == 0) {
        correct++;
      }
      total++;
      if (predict >= max) {
        max = predict;
      }
    }
    System.err.println(String.format("Result:%d/%d correct", correct, total));
  }

  public static int loadTestData(String file, List<Float[]> raw,
      List<Integer> y) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(file)));
    String line = br.readLine();
    int maxLength = 0;
    while (line != null) {
      line = line.trim();
      int temp = line.indexOf("#");
      // if (temp >= 0) {
      line = line.substring(0, temp).trim();
      // }
      String ss[] = line.split("\\s");

      y.add(new Integer(ss[0]));
      Float[] X = new Float[ss.length - 2];
      if (ss.length - 2 > maxLength) {
        maxLength = ss.length - 2;
      }
      for (int i = 2; i < ss.length; ++i) {
        String[] sss = ss[i].split(":");
        X[i - 2] = new Float(sss[1]);
      }
      raw.add(X);
      line = br.readLine();
    }
    br.close();
    return maxLength;
  }

  public static int loadTrainData(String file, List<Float[]> raw,
      List<Integer> y) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(file)));
    String line = br.readLine();
    int maxLength = 0;
    Map<Integer, List<Float[]>> positives = new HashMap<Integer, List<Float[]>>();
    Map<Integer, List<Float[]>> negatives = new HashMap<Integer, List<Float[]>>();
    while (line != null) {
      line = line.trim();
      int temp = line.indexOf("#");
      line = line.substring(0, temp).trim();
      String ss[] = line.split("\\s");
      // y.add(new Integer(ss[0]));
      int label = new Integer(ss[0]);
      Integer docid = new Integer(ss[1].split(":")[1]);

      Float[] X = new Float[ss.length - 2];
      if (ss.length - 2 > maxLength) {
        maxLength = ss.length - 2;
      }
      float norm = 0;
      for (int i = 2; i < ss.length; ++i) {
        String[] sss = ss[i].split(":");
        X[i - 2] = new Float(sss[1]);
        norm += Math.pow(X[i - 2], 2);
      }
      norm = (float)Math.sqrt(norm);
      if (norm > 0) {
        for (int i = 2; i < ss.length; ++i) {
          X[i - 2] = X[i - 2] / norm;
        }
      }
      // raw.add(X);
      if (!positives.containsKey(docid)) {
        positives.put(docid, new ArrayList<Float[]>());
        negatives.put(docid, new ArrayList<Float[]>());
      }

      if (label == 1) {
        positives.get(docid).add(X);
      } else {
        negatives.get(docid).add(X);
      }
      line = br.readLine();
    }
    br.close();

    for (Entry<Integer, List<Float[]>> e : positives.entrySet()) {
      List<Float[]> negs = negatives.get(e.getKey());
      List<Float[]> poss = e.getValue();
      for (Float[] dp : poss) {
        for (Float[] dn : negs) {
          raw.add(weightedSum(dp, 1, dn, -1));
          y.add(1);
          raw.add(weightedSum(dp, -1, dn, 1));
          y.add(0);

        }
      }
    }
    System.err.println(y.size());
    return maxLength;
  }

  public void train() {
    int iter = 0;
    boolean converged = false;
    float[] last = new float[model.length];
    while (iter < maxIter && !converged) {
      System.err.print(".");
      trainIteration();
      converged = true;
      for (int j = 0; j < model.length; ++j) {
        if (Math.abs(model[j] - last[j]) > epsilon) {
          converged = false;
          break;
        }
      }
      last = Arrays.copyOf(model, model.length);
      iter++;
    }
    if (converged) {
      System.err.println("\nLR classifier converge in " + iter + " iterations");
    } else {
      System.err.println("\nLR does not converge in " + iter + "iterations");
    }
    // System.err.println(Arrays.toString(classifier));
    // System.err.println(bias);
  }

  private void trainIteration() {
    // float learningRate =this.learningRate / round;
    // Collections.shuffle(shuffle);
    float decay = 1 - learningRate * C;
    float temp[] = new float[train_X[0].length];
    float bias_t = 0;
    for (int i = 0; i < train_X.length; ++i) {
      // int i = shuffle.get(ii);
      float predict = classify(train_X[i]);
      float forward = (train_y[i] - predict) * learningRate;
      bias_t += forward; // does not decay
      temp = weightedSum(temp, 1, train_X[i], forward);
      // bias += forward; // does not decay
      // FloatVector.weightedSum(classifier, decay, train_X[i], forward);
    }
    temp = weightedSum(model, decay, temp, 1);
    bias += bias_t;
  }

  static float overflow = 20;

  protected static float sigmoid(float score) {
    if (score > overflow)
      score = overflow;
    else if (score < -overflow)
      score = -overflow;
    float exp = (float)Math.exp(0 - score);
    return 1.0f / (1.0f + exp);
  }

  public float classify(float[] fv) {
    float dot = dotProduct(model, fv) + bias;
    float sig = sigmoid(dot);
    return sig;
  }

  public static float dotProduct(float[] v1, float[] v2) {
    if (v1.length != v2.length) {
      throw new IllegalArgumentException();
    }
    float res = 0;
    for (int i = 0; i < v1.length; ++i) {
      res += v1[i] * v2[i];
    }
    return res;
  }

  public static float[] weightedSum(float[] v1, float weight1, float[] v2, float weight2) {
    float[] ret = new float[v1.length];
    for (int i = 0; i < v1.length; ++i) {
      ret[i] = v1[i] * weight1 + v2[i] * weight2;
    }
    return ret;
  }  
  
  public static Float[] weightedSum(Float[] v1, float weight1, Float[] v2, float weight2) {
    Float[] ret = new Float[v1.length];
    for (int i = 0; i < v1.length; ++i) {
      ret[i] = v1[i] * weight1 + v2[i] * weight2;
    }
    return ret;
  }

  public static float[] normalize(float[] v1) {
    float norm = (float)Math.sqrt(dotProduct(v1, v1));
    float normalized[] = new float[v1.length];
    for (int i = 0; i < v1.length; ++i) {
      normalized[i] = v1[i] / norm;
    }
    return normalized;
  }
}
