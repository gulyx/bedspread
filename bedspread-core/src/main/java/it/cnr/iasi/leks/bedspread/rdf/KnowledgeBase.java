/*
 * 	 This file is part of Bedspread, originally promoted and
 *	 developed at CNR-IASI. For more information visit:
 *	 https://github.com/IASI-LEKS/bedspread
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
package it.cnr.iasi.leks.bedspread.rdf;

import java.util.Set;

/**
 * 
 * @author gulyx
 *
 */
public interface KnowledgeBase {

	public int degree(AnyResource resource);
	public int depth(AnyResource resource);
	public boolean isMemberof(AnyResource resource);
	public Set<AnyResource> getNeighborhood (AnyResource resource);
	
	public Set<AnyResource> getPredicatesBySubjectAndObject(AnyResource r1, AnyResource r2);
	public Set<AnyResource> getAllPredicates();
	public int countAllTriples();
	public int countTriplesByPredicate(AnyResource r);
	public int countTriplesBySubjectOrObject(AnyResource r);
	public int countTriplesByPredicateAndSubjectOrObject(AnyResource pred, AnyResource r);
}
