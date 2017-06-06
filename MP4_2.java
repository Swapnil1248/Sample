//import java.util.Scanner;
//
//import weka.classifiers.Classifier;
//import weka.classifiers.Evaluation;
//import weka.classifiers.evaluation.ConfusionMatrix;
//import weka.classifiers.functions.MultilayerPerceptron;
//import weka.classifiers.trees.J48;
//import weka.core.Instances;
//import weka.core.converters.ConverterUtils.DataSource;
//
////Reference: https://weka.wikispaces.com/Use+WEKA+in+your+Java+code
//public class MP4_2
//{
//
//	public static void main(String[] args)
//	{
//		DataSource trainSource;
//		DataSource testSource;
//		try
//		{
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Please provide the path for train arff");
//			String trainFileName = sc.nextLine();
//			// String trainFileName = "/home/swapnil/Desktop/ML_HSU/MP_4/lymph_train.arff";
//			System.out.println("Please provide the path for test arff");
//			String testFileName = sc.nextLine();
//			// String testFileName = "/home/swapnil/Desktop/ML_HSU/MP_4/lymph_test.arff";
//			trainSource = new DataSource(trainFileName);
//			testSource = new DataSource(testFileName);
//			Instances train = trainSource.getDataSet();
//			Instances test = testSource.getDataSet();
//			train.setClassIndex(train.numAttributes() - 1);
//			test.setClassIndex(test.numAttributes() - 1);
//			System.out.println("Please provide number of hidden layers");
//			// String numHiddenLayer = "3";
//			String numHiddenLayer = sc.nextLine();
//
//			MultilayerPerceptron mlp = new MultilayerPerceptron();
//
//			mlp.setLearningRate(0.1);
//			mlp.setMomentum(0.2);
//			mlp.setTrainingTime(2000);
//			mlp.setHiddenLayers(numHiddenLayer);
//
//			mlp.buildClassifier(train);
//
//			Evaluation eval = new Evaluation(train);
//			eval.evaluateModel(mlp, test);
//			printMatrix(eval.confusionMatrix());
//			System.out.println(eval.toMatrixString());;
//			System.out.println("Error Rate: " + 100 * eval.errorRate());
//			System.out.println(eval.toSummaryString());
//		}
//		catch (Exception e)
//		{
//
//		}
//
//	}
//
//	public static void printMatrix(double[][] matrix)
//	{
//
//		System.out.println("\t######Confusion Matrix#######");
//
//		System.out.println("\tTP " + matrix[0][0] + "\t\tFN " + matrix[0][1]);
//		System.out.println("\tFP " + matrix[1][0] + "\t\tTN " + matrix[1][1]);
//
//		System.out.println("Error rate: " + 100 * ((double) matrix[0][1] + (double) matrix[1][0]) / (matrix[0][0] + matrix[0][1] + matrix[1][0] + matrix[1][1]));
//	}
//
//}
