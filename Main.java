package exercise07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

class BrowserHistory {

	ArrayList<String> urlList = new ArrayList<>();
	LinkedList<String> linkedUrlList = new LinkedList<>();
	HashSet<String> urlSet = new HashSet<>();
	LinkedHashSet<String> linkedUrlSet = new LinkedHashSet<>();
	TreeSet<String> urlTreeSet = new TreeSet<>();

	public void visit(String url) {
		urlList.add(url);
		linkedUrlList.add(url);
		urlSet.add(url);
		linkedUrlSet.add(url);
		urlTreeSet.add(url);
	}

	public void sort() {
		Collections.sort(urlList);
		Collections.sort(linkedUrlList);
		List<String> sortedList = new ArrayList<>(urlSet);
		Collections.sort(sortedList);
		List<String> linkedSortedList = new ArrayList<>(linkedUrlSet);
		Collections.sort(linkedSortedList);
//		List<String> sortedTreeList = new ArrayList<>(urlTreeSet);
//		Collections.sort(sortedTreeList);
		System.out.println("ArrayList : ");
		for (String element : urlList) {
			System.out.println(element);
		}
		System.out.println("LinkedList : ");
		for (String element : linkedUrlList) {
			System.out.println(element);
		}
		System.out.println("Set : ");
		for (String element : sortedList) {
			System.out.println(element);
		}
		System.out.println("HashSet : ");
		for (String element : linkedSortedList) {
			System.out.println(element);
		}
		System.out.println("TreeSet : ");
		for (String element : urlTreeSet) {
			System.out.println(element);
		}
	}

	public void deleteHistory(String url) {
		urlList.remove(url);
		linkedUrlList.remove(url);
		urlSet.remove(url);
		linkedUrlSet.remove(url);
		urlTreeSet.remove(url);
	}

	public void fetchHistory() {
		System.out.println("ArrayList : ");
		for (String element : urlList) {
			System.out.println(element);
		}
		System.out.println("LinkedList : ");
		for (String element : linkedUrlList) {
			System.out.println(element);
		}
		System.out.println("Set : ");
		for (String element : urlSet) {
			System.out.println(element);
		}
		System.out.println("HashSet : ");
		for (String element : linkedUrlSet) {
			System.out.println(element);
		}
		System.out.println("TreeSet : ");
		for (String element : urlTreeSet) {
			System.out.println(element);
		}
	}

	public void search(String extension) {
		System.out.println("ArrayList : ");
		for (String element : urlList) {
			if (element.endsWith(extension)) {
				System.out.println(element);
			}
		}
		System.out.println("LinkedList : ");
		for (String element : linkedUrlList) {
			if (element.endsWith(extension)) {
				System.out.println(element);
			}
		}
		System.out.println("Set : ");
		for (String element : urlSet) {
			if (element.endsWith(extension)) {
				System.out.println(element);
			}
		}
		System.out.println("HashSet : ");
		for (String element : linkedUrlSet) {
			if (element.endsWith(extension)) {
				System.out.println(element);
			}
		}
		System.out.println("TreeSet : ");
		for (String element : urlTreeSet) {
			if (element.endsWith(extension)) {
				System.out.println(element);
			}
		}
	}
	
	public void size() {
		System.out.println("ArrayList : ");
		int urlListSize = urlList.size();
		System.out.println(urlListSize);
		
		System.out.println("LinkedList : ");
		int linkedUrlListSize = linkedUrlList.size();
		System.out.println(linkedUrlListSize);
		
		System.out.println("Set : ");
		int urlSetSize = urlSet.size();
		System.out.println(urlSetSize);
		
		System.out.println("HashSet : ");
		int linkedUrlSetSize = linkedUrlSet.size();
		System.out.println(linkedUrlSetSize);
		
		System.out.println("TreeSet : ");
		int urlTreeSetSize = urlTreeSet.size();
		System.out.println(urlTreeSetSize);
	}

	public void updateHistory(int updateIndex, String updatedUrl) {
		urlList.set(updateIndex, updatedUrl);
		linkedUrlList.set(updateIndex, updatedUrl);
		System.out.println("Enter url which you want to replace");
		Scanner sc5 = new Scanner(System.in);
		String oldUrl = sc5.nextLine();
		urlSet.remove(oldUrl);
		linkedUrlSet.remove(oldUrl);
		urlTreeSet.remove(oldUrl);
		urlSet.add(updatedUrl);
		linkedUrlSet.add(updatedUrl);
		urlTreeSet.add(updatedUrl);
	}
}

public class Main {
	public static void main(String[] args) {
		String continueOption;
		String url;
		String extension;
		String updatedUrl;
		int updateIndex;
		BrowserHistory browser = new BrowserHistory();
		do {
			System.out.println("Enter url");
			Scanner sc = new Scanner(System.in);
			url = sc.nextLine();
			browser.visit(url);
			System.out.println("Do you wish to continue?");
			Scanner sc1 = new Scanner(System.in);
			continueOption = sc1.nextLine();
		} while ("Y".equalsIgnoreCase(continueOption));
		
		browser.sort();
		
		System.out.println("Enter url to delete");
		Scanner sc2 = new Scanner(System.in);
		url = sc2.nextLine();
		browser.deleteHistory(url);
		browser.fetchHistory();
		
		System.out.println("Enter an extension to search");
		Scanner sc1 = new Scanner(System.in);
		extension = sc1.nextLine();
		browser.search(extension);
		
		browser.size();
		System.out.println("Enter index of the url you want to update");
		Scanner sc3 = new Scanner(System.in);
		updateIndex = sc3.nextInt();
		System.out.println("Enter new url");
		Scanner sc4 = new Scanner(System.in);
		updatedUrl = sc4.nextLine();
		browser.updateHistory(updateIndex, updatedUrl);
		browser.fetchHistory();

	}
}
