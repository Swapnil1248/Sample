import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {
	
	public static void main(String[] args){
		LetterCombination lc = new LetterCombination();
		List<String> output = lc.letterCombinations("23");
	}
	
	public List<String> letterCombinations(String digits) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		map.put(0, "");

		List<String> result = new ArrayList<String>();

		if (digits == null || digits.equals("")) {
			return result;
		}

		List<Character> current = new ArrayList<Character>();
		getLetterCombination(digits, result, current, map);

		return result;

	}

	private void getLetterCombination(String digits, List<String> result, List<Character> current,
			Map<Integer, String> map) {
		if (digits.length() == 0) {
			char[] arr = new char[current.size()];
			for (int i = 0; i < current.size(); i++) {
				arr[i] = current.get(i);
			}
			result.add(String.valueOf(arr));
			return;
		}

		Integer curr = Integer.valueOf(digits.substring(0, 1));
		String letters = map.get(curr);
		for (int i = 0; i < letters.length(); i++) {
			current.add(letters.charAt(i));
			getLetterCombination(digits.substring(1), result, current, map);
			current.remove(current.size() - 1);
		}
	}
}