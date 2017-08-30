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
import org.json.JSONException;
import org.json.JSONObject;

public class EnhancedSolrQueryHTTPClient extends SolrQueryHTTPClient {
	
    static Log logger = LogFactory.getLog(EnhancedSolrQueryHTTPClient.class);
	
	private static final String LOCALE_PARAM = "&locale=";
	
	@Override
	protected JSONResult postSolrQuery(HttpClient httpClient, String url, JSONObject body,
			SolrJsonProcessor<?> jsonProcessor, String spellCheckParams)
			throws UnsupportedEncodingException, IOException, HttpException, URIException, JSONException {
		
		int posPrev = url.toString().indexOf("&locale=");
		int posAfter = url.toString().indexOf("&", posPrev + 1 + LOCALE_PARAM.length());
		url = url.toString().substring(0, posPrev) + url.toString().substring(posAfter);
		
		logger.debug("Sanitized URL: " + url);
		
		return super.postSolrQuery(httpClient, url, body, jsonProcessor, spellCheckParams);
		
	}

}
