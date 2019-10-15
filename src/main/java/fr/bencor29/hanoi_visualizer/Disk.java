package fr.bencor29.hanoi_visualizer;

import java.awt.Color;

public class Disk {
	
	/**
	 * Taille du disque
	 */
	private int size;
	
	/**
	 * Coordonnée X
	 */
	private int x;
	
	/**
	 * Coordonnée Y
	 */
	private int y;
	
	/**
	 * Coordonnée Y
	 */
	private int z;
	
	/**
	 * Couleur du disque
	 */
	private Color color;
	
	/**
	 * Condtructeur de la classe
	 * @param size Taille du disque
	 * @param color Couleur du disque
	 */
	public Disk(int size, Color color)
	{
		this.size = size;
		this.color = color;
	}

	/**
	 * Récupère la coordonnée X
	 * @return int X
	 */
	public int getX() {
		return x;
	}

	/**
	 * Défini la coordonnée X
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}


	/**
	 * Récupère la coordonnée Y
	 * @return int Y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Défini la coordonnée Y
	 * @param Y
	 */
	public void setY(int y) {
		this.y = y;
	}


	/**
	 * Récupère la coordonnée Z
	 * @return int Z
	 */
	public int getZ() {
		return z;
	}

	/**
	 * Défini la coordonnée Z
	 * @param Z
	 */
	public void setZ(int z) {
		this.z = z;
	}

	/**
	 * Récupère la taille
	 * @return int size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Récupère la couleur
	 * @return Color la couleur
	 */
	public Color getColor() {
		return color;
	}
	
	

}
