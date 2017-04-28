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
package it.cnr.iasi.leks.bedspread.rdf.sparqlImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * 
 * @author ftaglino
 *
 */
public class DBpediaKBCache {
	
	int num_total_triple = 0;
	
	Map<String, Integer> num_triples_by_predicate = new HashMap<String, Integer>();
	Map<String, Integer> num_triples_by_subject = new HashMap<String, Integer>();
	Map<String, Integer> num_triples_by_object = new HashMap<String, Integer>();
	Map<String, Integer> num_triples_by_subject_or_object = new HashMap<String, Integer>();
	
	Map<Vector<String>, Integer> num_triples_by_predicate_and_subject = new HashMap<Vector<String>, Integer>();
	Map<Vector<String>, Integer> num_triples_by_predicate_and_object = new HashMap<Vector<String>, Integer>();
	Map<Vector<String>, Integer> num_triples_by_subject_and_object = new HashMap<Vector<String>, Integer>();
	Map<Vector<String>, Integer> num_triples_by_predicate_and_subject_or_object = new HashMap<Vector<String>, Integer>();
	
	
	public DBpediaKBCache() {
	
	}

}
