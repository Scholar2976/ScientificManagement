
package com.hospital301.scientificmanagement.util;

import java.util.ArrayList;
import java.util.List;

import com.ccb.sm.entities.Menu;
import com.sun.corba.se.impl.orbutil.graph.NodeData;

public class TreeUtil {

	/**
	 * 获取所有根节点
	 * 
	 * @param nodes
	 *            所有节点
	 * @return
	 */
	public static List<Menu> data(List<Menu> nodes) {
		ArrayList<Menu> rootNode = new ArrayList<Menu>();
		for (Menu node : nodes) {
			if(node.getMenuId().equals("000000000"))
				continue;
			if (node.getParent().equals("000000000")) {
				rootNode.add(node);
			}
		}
		for (Menu node : rootNode) {
			List<Menu> child = getChild(String.valueOf(node.getMenuId()), nodes);
			node.setChildren(child);
		}
		return rootNode;
	}

	/**
	 * 递归获取所有根节点子节点
	 * 
	 * @param id
	 *            当前节点
	 * @param allNode
	 *            所有节点
	 * @return
	 */
	private static  List<Menu> getChild(String id, List<Menu> allNode) {
		// 存放子菜单的集合
		ArrayList<Menu> listChild = new ArrayList<>();
		for (Menu node : allNode) {
			if (node.getParent()!= null && node.getParent().equals(id)) {
				listChild.add(node);
			}
		}
		// 递归：
		for (Menu node : listChild) {
			node.setChildren(getChild(String.valueOf(node.getMenuId()), allNode));
		}
		if (listChild.size() == 0) {
			return null;
		}
		return listChild;
	}
}