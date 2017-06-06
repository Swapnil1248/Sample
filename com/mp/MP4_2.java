//package com.mp;
//
//import java.util.Scanner;
//
//import weka.classifiers.Evaluation;
//import weka.classifiers.functions.MultilayerPerceptron;
//import weka.core.Instances;
//import weka.core.converters.ConverterUtils.DataSource;
//
////Reference: https://weka.wikispaces.com/Use+WEKA+in+your+Java+code
//
//public class MP4_2
//{
//
//	public static void main(String[] args)
//	{
//		DataSource trainSet;
//		DataSource testSet;
//		try
//		{
//			if(args.length < 2)
//			{
//				System.out.println("Usage: java MP4_2 lymph_train.arff lymph_test.arff");
//				System.exit(0);
//			}
//
//			String trainFileName = args[0];
//
//			String testFileName = args[1];
//
//			trainSet = new DataSource(trainFileName);
//			testSet = new DataSource(testFileName);
//			Instances train = trainSet.getDataSet();
//			Instances test = testSet.getDataSet();
//			train.setClassIndex(train.numAttributes() - 1);
//			test.setClassIndex(test.numAttributes() - 1);
//			System.out.print("Enter number of hidden layers: ");
//			Scanner inKey = new Scanner(System.in);
//			String layers = inKey.nextLine();
//
//			MultilayerPerceptron mlp = new MultilayerPerceptron();
//
//			mlp.setLearningRate(0.1);
//			mlp.setMomentum(0.2);
//			mlp.setTrainingTime(2000);
//			mlp.setHiddenLayers(layers);
//
//			mlp.buildClassifier(train);
//
//			Evaluation eval = new Evaluation(train);
//			eval.evaluateModel(mlp, test);
//			System.out.println(eval.toMatrixString());;
//			System.out.println("Error Rate: " + 100 * eval.errorRate());
//			System.out.println(eval.toSummaryString());
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//
//	}
//
//}