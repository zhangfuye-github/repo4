package com.itheima;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/*
 * 
 * 1.SAXReader����
 * 		a)	read(��) ����ִ��xml�ĵ� ����Document����
 * 2.Document����
 * 		a)	getRootElement() ��ø�Ԫ��
 * 3.Element����
 *		a)	elements(��) ���ָ�����Ƶ�������Ԫ�ء����Բ�ָ������
 * 		b)	element(��) ���ָ�����Ƶ�һ����Ԫ�ء����Բ�ָ������
 * 		c)	getName() ��õ�ǰԪ�ص�Ԫ����
 * 		d)	attributeValue(��) ���ָ��������������ֵ
 * 		e)	elementText(��) ���ָ��������Ԫ�ص��ı�ֵ
 * 		f)	getText() ��õ�ǰԪ�ص��ı�����
 */
public class Demo01_Dom4j {

	public static void main(String[] args) throws Exception {

		SAXReader sr = new SAXReader();

		Document doc = sr.read("1_xml/src/beans.xml");

		Element root = doc.getRootElement();

		List<Element> list = root.elements(); 

		for(Element bean : list){

			String id = bean.attributeValue("id");
			String className = bean.attributeValue("className");
			System.out.println(id + ".."+className);

			List<Element> propertyList = bean.elements();

			for(Element property:propertyList){

				String name = property.attributeValue("name");
				String value = property.attributeValue("value");
				System.out.println(name + ".." + value);
			}
		}
	}
}








