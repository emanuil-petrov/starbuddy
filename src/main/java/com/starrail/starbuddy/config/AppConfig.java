package com.starrail.starbuddy.config;

import com.starrail.starbuddy.util.ArtifactScorer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ArtifactScorer artifactScorer() {
        return new ArtifactScorer();
    }







}
