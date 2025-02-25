/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 *
 * @author ayushpuri
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.mediumposts.repository")
@ComponentScan(basePackages = { "com.mediumposts.service" })
public class Elastic_Config extends ElasticsearchConfiguration {
        
    @Override
    public ClientConfiguration clientConfiguration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clientConfiguration'");
    }   
    
} 
