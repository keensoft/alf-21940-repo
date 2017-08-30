package es.keensoft.repo.search.impl.solr;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.alfresco.repo.search.impl.lucene.JSONResult;
import org.alfresco.repo.search.impl.lucene.SolrJsonProcessor;
import org.alfresco.repo.search.impl.solr.SolrQueryHTTPClient;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Find results for every locale by using '*' as parameter value
public class EnhancedSolrQueryHTTPClient extends SolrQueryHTTPClient {
	
    static Log logger = LogFactory.getLog(EnhancedSolrQueryHTTPClient.class);
	
	private static final String LOCALE_PARAM = "&locale=";
	
	@Override
	protected JSONResult postSolrQuery(HttpClient httpClient, String url, JSONObject body,
			SolrJsonProcessor<?> jsonProcessor, String spellCheckParams)
			throws UnsupportedEncodingException, IOException, HttpException, URIException, JSONException {
		
		// Sanitize URL
	    int posPrev = url.toString().indexOf("&locale=");
		int posAfter = url.toString().indexOf("&", posPrev + 1 + LOCALE_PARAM.length());
		url = url.toString().substring(0, posPrev) + "&locale=*" + url.toString().substring(posAfter);
		logger.debug("Sanitized URL: " + url);
		
		// Sanitize Body
		body.remove("locales");
		JSONArray locales = new JSONArray();
		locales.put("*");
		body.put("locales", locales);
		logger.debug("Sanitized Body: " + body);
		
		return super.postSolrQuery(httpClient, url, body, jsonProcessor, spellCheckParams);
		
	}

}
