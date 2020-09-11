package com.noodles.datastructure.graph;

/**
 * @filename IGraph
 * @description 图接口
 * @author 巫威
 * @date 2020/9/11 17:12
 */
public interface IGraph<E> {

	/**
	 * 创建一个图
	 * @author 巫威
	 * @date 2020/9/11 17:15
	 */
	void createGraph();

	/**
	 * 返回图中的顶点数
	 * @return int
	 * @author 巫威
	 * @date 2020/9/11 17:15
	 */
	int getVexNum();

	/**
	 * 返回图中的边数
	 * @return int
	 * @author 巫威
	 * @date 2020/9/11 17:15
	 */
	int getArcNum();

	/**
	 * 给定顶点的位置返回顶点值
	 * @param v
	 * @return E
	 * @author 巫威
	 * @date 2020/9/11 17:15
	 */
	E getVex(int v);

	/**
	 * 给点顶点的值，返回其在图中的位置
	 * @param vex
	 * @return int
	 * @author 巫威
	 * @date 2020/9/11 17:15
	 */
	int locateVex(E vex);

	/**
	 * 返回v的第一个邻接点
	 * @param v
	 * @return int
	 * @author 巫威
	 * @date 2020/9/11 17:15
	 */
	int firstAdjVex(int v);

	/**
	 * 返回v相对于w的下一个邻接点
	 * @param v
	 * @param w
	 * @return int
	 * @author 巫威
	 * @date 2020/9/11 17:15
	 */
	int nextAdjVex(int v, int w);


}
