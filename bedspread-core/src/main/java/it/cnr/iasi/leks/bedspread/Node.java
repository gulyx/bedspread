/*
 * 	 This file is part of Bedspread, originally promoted and
 *	 developed at CNR-IASI. For more information visit:
 *	 http://leks.iasi.cnr.it/tools/bedspread
 *	     
 *	 This is free software: you can redistribute it and/or modify
 *	 it under the terms of the GNU General Public License as 
 *	 published by the Free Software Foundation, either version 3 of the 
 *	 License, or (at your option) any later version.
 *	 
 *	 This software is distributed in the hope that it will be useful,
 *	 but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	 GNU General Public License for more details.
 * 
 *	 You should have received a copy of the GNU General Public License
 *	 along with this source.  If not, see <http://www.gnu.org/licenses/>.
 */
package it.cnr.iasi.leks.bedspread;

import it.cnr.iasi.leks.bedspread.rdf.AnyResource;

/**
 * @author gulyx
 */
public class Node {
	private AnyResource resource;
	private double activationScore;
	
	private final Object MUTEX = new Object();
	
	public Node(AnyResource resource){
		this.resource = resource;
		this.activationScore = 0;
	}
	
	public AnyResource getResource(){
		return this.resource;
	}
	
	public double getScore(){
		double s;
		synchronized (MUTEX) {
			s = this.activationScore;
		}
		return s;
	}
	
	public void updateScore(double s){
		synchronized (MUTEX) {
			this.activationScore = s;
		}
	}
	
	/*
	 * Note that this method changed.
	 * Now the implementation strictly relay on the override of "equals" that any implementation
	 * of AnyResource must provide.
	 * 
	 * @see	it.cnr.iasi.leks.bedspread.rdf.URIImpl
	 * @see	it.cnr.iasi.leks.bedspread.rdf.BlankNodeImpl
	 * @see	it.cnr.iasi.leks.bedspread.rdf.LiteralImpl
	 * 
	 */
	@Override
	public boolean equals (Object obj){
		if (obj instanceof Node) {
			Node node = (Node) obj;
			AnyResource resource = node.getResource();
			
			return this.getResource().equals(resource); 
		}	
		return false;		
	}
	
	/*
	 * Note that this method changed.
	 * Now the implementation strictly relay on the override of "hashCode" that any implementation
	 * of AnyResource must provide.
	 * 
	 * @see	it.cnr.iasi.leks.bedspread.rdf.URIImpl
	 * @see	it.cnr.iasi.leks.bedspread.rdf.BlankNodeImpl
	 * @see	it.cnr.iasi.leks.bedspread.rdf.LiteralImpl
	 * 
	 */
	@Override
	public int hashCode(){
		return this.resource.hashCode();
	}
}
