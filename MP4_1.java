import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.IntStream;

public class MP4_1
{

	public static void main(String[] args)
	{
		Model model = new Model("/home/swapnil/Desktop/ML_HSU/MP_4/lymph_train.arff");
		model.getValues();
		model.trainClassifier();
		int[][] matrix = model.testClassifiers("/home/swapnil/Desktop/ML_HSU/MP_4/lymph_test.arff");
		model.printMatrix(matrix);
	}
}

class Model
{
	private String trainingFile;
	private Map<String, List<String>> features;
	private List<String> featureNameList;
	private Map<String, Integer> featureCounts;
	private List<List<String>> featureVectors;
	private Map<String, Integer> labelCounts;

	Model(String arffFile)
	{
		this.trainingFile = arffFile;
		this.features = new HashMap<String, List<String>>();
		this.featureNameList = new ArrayList<String>();
		this.featureCounts = new HashMap<String, Integer>();
		this.featureVectors = new ArrayList<List<String>>();
		this.labelCounts = new HashMap<String, Integer>();
	}

	public void printMatrix(int[][] matrix)
	{
		String[] keys = new String[2];
		int i = 0;
		for (String key : labelCounts.keySet())
		{
			keys[i++] = key;
		}
		System.out.println("\t######Confusion Matrix#######");
		System.out.println("\t \t" + keys[0] + "\t" + keys[1]);
		System.out.println(keys[0] + "\tTP " + matrix[0][0] + "\t\tFN " + matrix[0][1]);
		System.out.println(keys[1] + "\tFP " + matrix[1][0] + "\t\tTN " + matrix[1][1]);

		System.out.println("Error rate: " + 100 * ((double) matrix[0][1] + (double) matrix[1][0]) / (matrix[0][0] + matrix[0][1] + matrix[1][0] + matrix[1][1]));
	}

	public void trainClassifier()
	{
		for (List<String> featureVector : featureVectors)
		{
			String key = featureVector.get(featureVector.size() - 1);
			if (labelCounts.get(key) == null)
			{
				labelCounts.put(key, 1);
			}
			else
			{
				labelCounts.put(key, labelCounts.get(key) + 1);
			}
			int len = featureVector.size();
			for (int counter = 0; counter < len; counter++)
			{
				String counterKey = featureVector.get(featureVector.size() - 1) + this.featureNameList.get(counter) + featureVector.get(counter);
				if (featureCounts.get(counterKey) == null)
				{
					featureCounts.put(counterKey, 1);
				}
				else
				{
					featureCounts.put(counterKey, featureCounts.get(counterKey) + 1);
				}
			}
		}

		for (Entry<String, Integer> label : labelCounts.entrySet())
		{
			for (String feature : featureNameList)
				labelCounts.put(label.getKey(), labelCounts.get(label.getKey()) + features.get(feature).size());
		}

	}

	public int[][] testClassifiers(String fileName)
	{
		BufferedReader br = null;
		int[][] confusionMatrix = new int[2][2];
		try
		{
			br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine();
			List<String> featureList = null;
			String[] keys = new String[2];
			int i = 0;
			for (String key : labelCounts.keySet())
			{
				keys[i++] = key;
			}
			while (line != null)
			{
				line = line.trim();
				if (!line.startsWith("@"))
				{
					String[] lineContent = line.toLowerCase().split(",");
					featureList = Arrays.asList(lineContent);
					String predicted = classify(featureList);
					String actual = lineContent[lineContent.length - 1];
					 //System.out.println("");
					 //System.out.print("Classifier: " + predicted);
					 //System.out.print(" given " + actual);
					if (predicted.equals(keys[0]) && actual.equals(keys[0]))
					{
						confusionMatrix[0][0]++;
					}
					if (predicted.equals(keys[0]) && actual.equals(keys[1]))
					{
						confusionMatrix[1][0]++;
					}
					if (predicted.equals(keys[1]) && actual.equals(keys[1]))
					{
						confusionMatrix[1][1]++;
					}
					if (predicted.equals(keys[1]) && actual.equals(keys[0]))
					{
						confusionMatrix[0][1]++;
					}
				}
				line = br.readLine();
				// System.out.println(Arrays.deepToString(confusionMatrix));
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				br.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return confusionMatrix;
	}

	private String classify(List<String> featureVector)
	{
		Map probabilityPerLabel = new HashMap();
		String bestLabel = "";
		double bestProbability = Double.NEGATIVE_INFINITY;
		int lCount = labelCounts.values().stream().mapToInt(Number::intValue).sum();
		for (Entry<String, Integer> label : labelCounts.entrySet())
		{
			double logProbability = 0;
			for (String featureValue : featureVector)
			{
				int featureValueIndex = 0;
				featureValueIndex = getFeatureVectorIndex(featureValue, featureVector);
				String counterKey = label.getKey() + this.featureNameList.get(featureValueIndex) + featureValue;
				// System.out.print(counterKey);
				double val = featureCounts.get(counterKey) != null ? featureCounts.get(counterKey) : 1;
				logProbability += Math.log(val / label.getValue());
			}
			double probability = ((labelCounts.get(label.getKey()) != null) ? ((double) labelCounts.get(label.getKey()) / lCount) : 0) * Math.exp(logProbability);
			// System.out.println("Probability "+probability+" Label "+ label);
			if (probability > bestProbability)
			{
				bestProbability = probability;
				bestLabel = label.getKey();
			}
			probabilityPerLabel.put(label, probability);
		}
		return bestLabel;
	}

	private int getFeatureVectorIndex(String featureValue, List<String> featureVector)
	{
		int retVal = 0;
		int len = featureVector.size();
		for (int i = 0; i < len; i++)
		{
			if (featureValue.equals(featureVector.get(i)))
				return i;
		}
		return retVal;
	}

	public void getValues()
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(this.trainingFile));
			String line = null;
			while ((line = br.readLine()) != null)
			{
				if(line.trim().startsWith("%"))
					continue;
				String[] lineContent;
				if (!line.startsWith("@"))
				{
					lineContent = line.trim().toLowerCase().split(",");
					featureVectors.add(Arrays.asList(lineContent));
				}
				else
				{
					line = line.trim().toLowerCase();
					if (!line.contains("@data") && !line.startsWith("@relation"))
					{
						// System.out.println(line);
						lineContent = line.split("\\s+");
						String featureNameKey = lineContent[1].substring(1, lineContent[1].length() - 1);
						this.featureNameList.add(featureNameKey);
						int startBraceIndex = line.indexOf('{');
						int endBraceIndex = line.indexOf('}');
						line = line.substring(startBraceIndex + 1, endBraceIndex).trim();
						lineContent = line.split(",");
						this.features.put(featureNameKey, Arrays.asList(lineContent));
					}
				}
			}
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			// br.close();
		}
	}
}