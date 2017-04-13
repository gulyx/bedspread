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
package it.cnr.iasi.leks.bedspread.tests;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import it.cnr.iasi.leks.bedspread.rdf.AnyResource;
import it.cnr.iasi.leks.bedspread.rdf.impl.RDFFactory;
import it.cnr.iasi.leks.bedspread.rdf.URI;
import it.cnr.iasi.leks.bedspread.rdf.sparqlImpl.DBpediaKB;
import it.cnr.iasi.leks.bedspread.rdf.sparqlImpl.Filters;
import it.cnr.iasi.leks.bedspread.rdf.sparqlImpl.SPARQLQueryCollector;

public class SPARQLQueryCollectorTest {

	private static final URI r1 = RDFFactory.getInstance().createURI("http://dbpedia.org/resource/Barack_Obama");
	private static final URI r2 = RDFFactory.getInstance().createURI("http://dbpedia.org/resource/Joe_Biden");

	private static DBpediaKB kb = DBpediaKB.getInstance();
	
	@Test
	public void getPredicatesBySubjectAndObject() {
		Set<AnyResource> result = new HashSet<AnyResource>();
		
		result = SPARQLQueryCollector.getPredicatesBySubjectAndObject(kb, r1, r2, Filters.FILTER_OUT_BLACKLIST_PREDICATES);
		
		for(AnyResource p:result)
			System.out.println("pred="+p.getResourceID());
		
		Assert.assertTrue(result.size()>0);
	}
	
	//@Test
	public void getBow() {
		Set<AnyResource> result = new HashSet<AnyResource>();
		result = SPARQLQueryCollector.getBow(kb, Filters.FILTER_OUT_ALL);
		
		for(AnyResource n:result)
			System.out.println("node="+n.getResourceID());

		Assert.assertTrue(result.size()>0);
	}
}
