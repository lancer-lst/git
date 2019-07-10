package com.lst.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


/**
 * ��ҳ������
 *  
 */
public final class PageUtil {
	/**
	 * ��ҳ����ʾ
	 * @param request 
	 * @param url      �����mapping·��
	 * @param pageSize ÿҳ��ʾ����������
	 * @param list     ��ʾ��list����
	 * @param listCount һ���ж���������
	 * @param page     ��ǰҳ��
	 */
	public static void page(HttpServletRequest request, String url, Integer pageSize, List<?> list, Integer listCount, Integer page) {
		// ͨ������Ҫ�����������ҳ����ʾ����������ҳ��
		int pageCount = listCount/pageSize + (listCount%pageSize == 0 ? 0 : 1);
		//System.out.println("pageCount=="+pageCount);
		// �ж�url���Ƿ���?�ţ�����У�����ͨ��&���Ž������ӣ�����ͨ��?��������
		String flag = url.indexOf("?") != -1 ? "&" : "?";
		
		
		
		// ��ҳ����ҳ����һҳ����һҳ��ĩҳ
		String first = "";
		String prev ="";
		String next = "";
		String last = "";
		
		if(page != 1) {
			first = "<a href='"+request.getContextPath()+url+flag+"page=1'>��ҳ</a>";
		} else {
			first = "��ҳ";
		}
		
		if(page > 1) {
			prev = "<a href='"+request.getContextPath()+url+flag+"page="+(page-1)+"'>��һҳ</a>";
		} else {
			prev = "��һҳ";
		}
		
		if(page < pageCount) {
			next = "<a href='"+request.getContextPath()+url+flag+"page="+(page + 1)+"'>��һҳ</a>";
		} else {
			next = "��һҳ";
		}
		
		if(page != pageCount) {
			last = "<a href='"+request.getContextPath()+url+flag+"page="+pageCount+"'>ĩҳ</a>";
		} else {
			last = "ĩҳ";
		}
		request.setAttribute("page", "����"+listCount+"������"+" ��ǰΪ��"+page+"ҳ &nbsp;"+first+" "+prev+" "+next+" "+last);
	}
	
}
