package io.waterdrop.datastructure.list;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * 链表逆置有两种方法：1.遍历原链表，将元素按照头插法插入新链表 ；  
 * 
 * 2就地逆置法  （两种方法都可以分别按照迭代和递归两种方式实现）
 * 
 * 遍历原链表
 * 
 * 链表逆置过程中可以认为是从原链表中从头拿出元素插入新链表的头部，从而实现逆置 （简言之就是从原链表中遍历元素，插入（头插法）到新链表当中,）。
 * 
 * 递归
 * 
 * 递归地将原链表中的元素按照头插法插入到新链表中
 * 
 * @author liangyh
 *
 */
public class ReverseList<Element> {
	/**
	 * 指针法
	 * 
	 * 
	 */
	public SingleList<String> generateSingleList() {
		SingleList<String> list = new SingleList<String>();

		list.insertHead("1");
		list.insertHead("2");
		list.insertHead("3");
		list.insertHead("4");
		list.insertHead("5");
		return list;
	}

	public SingleList<Element> reverseList(SingleList<Element> list) {
		SingleList<Element> reverseList = new SingleList<Element>();
		Iterator<Element> listIterator = list.iterator();
		/**
		 * 可行，但是要注意next()函数的使用，以免死循环
		 */
		while (listIterator.hasNext()) {

			Element element = list.deleteHead();
			reverseList.insertHead(element);
			listIterator.next();

		}
		/*
		 * //此法可用 for (Element element : list) { //Element element =
		 * list.deleteHead(); reverseList.insertHead(element); }
		 */
		return reverseList;
	}
	
	public SingleList<Element> recursiveReverseList(SingleList<Element> list) {
		SingleList<Element> reverseList = new SingleList<>();
		recursiveReserse(reverseList,list);
		return reverseList;
	}

	private void recursiveReserse(SingleList<Element> reverseList, SingleList<Element> list) {
		if(!list.isEmpty()){
		reverseList.insertHead(list.deleteHead());
		recursiveReserse(reverseList,list);
		}
	}

	public static void main(String[] args) {
		ReverseList<String> reverseList = new ReverseList();

		for (String string : reverseList.generateSingleList()) {
			System.out.println(string);
		}
		System.out.println("-------------------------------------------------------------------");

		SingleList<String> reversedlist = reverseList.reverseList(reverseList.generateSingleList());

		for (String string : reversedlist) {
			System.out.println(string);
		}
		
		System.out.println("-------------------------------------------------------------------");

		SingleList<String> reversedlistWithRecursive = reverseList.recursiveReverseList(reverseList.generateSingleList());

		for (String string : reversedlistWithRecursive) {
			System.out.println(string);
		}
	}
	
	
}
