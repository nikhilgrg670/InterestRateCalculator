package com.macquarie.niks.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.couchbase.config.AbstractReactiveCouchbaseConfiguration;
 
//@Configuration
//@EnableReactiveCouchbaseRepositories(basePackages = "com.macquarie.niks.dao")
public class CouchbaseConfig extends AbstractReactiveCouchbaseConfiguration
{  
    @Value("${port}")
    private String port;
     
    @Value("${dbname}")
    private String dbName;
 
	@Override
	protected List<String> getBootstrapHosts() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	protected String getBucketName() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	protected String getBucketPassword() {
		// TODO Auto-generated method stub
		return null;
	}
}