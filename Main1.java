package exercise07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.LinkedHashMap;
import java.util.TreeMap;

class BrowserHistory1 {
	private HashMap<String, List<String>> hashMap = new HashMap<>();
	private LinkedHashMap<String, List<String>> linkedHashMap = new LinkedHashMap<>();
	private TreeMap<String, List<String>> treeMap = new TreeMap<>();

	public void visitHashMap(String url) {
		String[] urlParts = url.split("\\.");
		String extension = urlParts[1];
		if (!hashMap.containsKey(extension)) {
			hashMap.put(extension, new ArrayList<>());
		}
		hashMap.get(extension).add(url);
	}

	public void visitLinkedHashMap(String url) {
		String[] urlParts = url.split("\\.");
		String extension = urlParts[1];
		if (!linkedHashMap.containsKey(extension)) {
			linkedHashMap.put(extension, new ArrayList<>());
		}
		linkedHashMap.get(extension).add(url);
	}

	public void visitTreeMap(String url) {
		String[] urlParts = url.split("\\.");
		String extension = urlParts[1];
		if (!treeMap.containsKey(extension)) {
			treeMap.put(extension, new ArrayList<>());
		}
		treeMap.get(extension).add(url);
	}

	public void fetchHistoryHashMap(String extension) {
		List<String> urls = hashMap.get(extension);
		for (String url : urls) {
			System.out.println(url);
		}
	}

	public void fetchHistoryLinkedHashMap(String extension) {
		List<String> urls = linkedHashMap.get(extension);
		for (String url : urls) {
			System.out.println(url);
		}
	}

	public void fetchHistoryTreeMap(String extension) {
		List<String> urls = treeMap.get(extension);
		for (String url : urls) {
			System.out.println(url);
		}
	}

	public void deleteHistoryHashMap(String extension) {
		hashMap.remove(extension);
		System.out.println(hashMap.entrySet());
	}

	public void deleteHistoryLinkedHashMap(String extension) {
		linkedHashMap.remove(extension);
		System.out.println(linkedHashMap.entrySet());
	}

	public void deleteHistoryTreeMap(String extension) {
		treeMap.remove(extension);
		System.out.println(treeMap.entrySet());
	}

	public void sizeHashMap(String extension) {
		List<String> urls = hashMap.get(extension);
		System.out.println(urls.size());
	}

	public void sizeLinkedHashMap(String extension) {
		List<String> urls = linkedHashMap.get(extension);
		System.out.println(urls.size());
	}

	public void sizeTreeMap(String extension) {
		List<String> urls = treeMap.get(extension);
		System.out.println(urls.size());
	}

	public void searchHashMap(String word) {
		List<String> matchingUrls = new ArrayList<>();

		for (List<String> urls : hashMap.values()) {
			for (String url : urls) {
				String[] urlParts = url.split("\\.");
				if (urlParts[0].contains(word)) {
					matchingUrls.add(url);
				}
			}
		}
		for (String url : matchingUrls) {
			System.out.println(url);
		}
	}

	public void searchLinkedHashMap(String word) {
		List<String> matchingUrls = new ArrayList<>();
		for (List<String> urls : linkedHashMap.values()) {
			for (String url : urls) {
				String[] urlParts = url.split("\\.");
				if (urlParts[0].contains(word)) {
					matchingUrls.add(url);
				}
			}
		}
		for (String url : matchingUrls) {
			System.out.println(url);
		}
	}

	public void searchTreeMap(String word) {
		List<String> matchingUrls = new ArrayList<>();
		for (Entry<String, List<String>> entry : treeMap.entrySet()) {
			List<String> urls = entry.getValue();
			for (String url : urls) {
				String[] urlParts = url.split("\\.");
				if (urlParts[0].contains(word)) {
					matchingUrls.add(url);
				}
			}
		}
		for (String url : matchingUrls) {
			System.out.println(url);
		}
	}
}

class Main1 {
	public static void main(String[] args) {
		BrowserHistory1 browserHistory = new BrowserHistory1();
		String continueOption;
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Please select an option:");
			System.out.println("1. Visit URL");
			System.out.println("2. Fetch history by file extension");
			System.out.println("3. Delete history by file extension");
			System.out.println("4. Size of history by file extension");
			System.out.println("5. Search history by keyword");
			System.out.println("6. Exit");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Please enter the URL:");
				String url = scanner.next();
				browserHistory.visitHashMap(url);
				browserHistory.visitLinkedHashMap(url);
				browserHistory.visitTreeMap(url);
				break;
			case 2:
				System.out.println("Please enter the file extension:");
				String extension = scanner.next();
				System.out.println("HashMap:");
				browserHistory.fetchHistoryHashMap(extension);
				System.out.println("LinkedHashMap:");
				browserHistory.fetchHistoryLinkedHashMap(extension);
				System.out.println("TreeMap:");
				browserHistory.fetchHistoryTreeMap(extension);
				break;
			case 3:
				System.out.println("Please enter the file extension:");
				extension = scanner.next();
				System.out.println("HashMap:");
				browserHistory.deleteHistoryHashMap(extension);
				System.out.println("LinkedHashMap:");
				browserHistory.deleteHistoryLinkedHashMap(extension);
				System.out.println("TreeMap:");
				browserHistory.deleteHistoryTreeMap(extension);
				break;
			case 4:
				System.out.println("Please enter the file extension:");
				extension = scanner.next();
				System.out.println("HashMap:");
				browserHistory.sizeHashMap(extension);
				System.out.println("LinkedHashMap:");
				browserHistory.sizeLinkedHashMap(extension);
				System.out.println("TreeMap:");
				browserHistory.sizeTreeMap(extension);
				break;
			case 5:
				System.out.println("Please enter the keyword:");
				String keyword = scanner.next();
				System.out.println("HashMap:");
				browserHistory.searchHashMap(keyword);
				System.out.println("LinkedHashMap:");
				browserHistory.searchLinkedHashMap(keyword);
				System.out.println("TreeMap:");
				browserHistory.searchTreeMap(keyword);
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Invalid choice, please select again.");
				break;
			}
			
			System.out.println("Do you wish to continue?");
			Scanner sc = new Scanner(System.in);
			continueOption = sc.nextLine();
		}while("Yes".equalsIgnoreCase(continueOption));
	}
}
