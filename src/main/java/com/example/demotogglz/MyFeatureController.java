package com.example.demotogglz;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

@RestController
public class MyFeatureController {
    private FeatureManager manager;

    public MyFeatureController(FeatureManager manager) {
        this.manager = manager;
    }
    Map<String, Boolean> features = new HashMap<>();

    private Logger logger = LoggerFactory.getLogger(MyFeatureController.class);

    @RequestMapping(value = "/feature", method = RequestMethod.GET)
    public Map<String, Boolean> index() {
        boolean greetingFeature = manager.isActive(FeatureOptions.GREETINGS_FEATURE);
        features.put(FeatureOptions.GREETINGS_FEATURE.name(), greetingFeature);
        if (greetingFeature) {
            logger.info("{} is enabled", FeatureOptions.GREETINGS_FEATURE.name());
        } else {
            logger.info("{} is not enabled", FeatureOptions.GREETINGS_FEATURE.name());
        }

        boolean publishFeature = manager.isActive(FeatureOptions.PUBLISH_FEATURE);
        features.put(FeatureOptions.PUBLISH_FEATURE.name(), publishFeature);
        if (publishFeature) {
            logger.info("{} is enabled", FeatureOptions.PUBLISH_FEATURE.name());
        } else {
            logger.info("{} is not enabled", FeatureOptions.PUBLISH_FEATURE.name());
        }

        boolean uiComponentFeature = manager.isActive(FeatureOptions.UI_COMPONENTS_FEATURE);
        features.put(FeatureOptions.UI_COMPONENTS_FEATURE.name(), uiComponentFeature);
        if (uiComponentFeature) {
            logger.info("{} is enabled", FeatureOptions.UI_COMPONENTS_FEATURE.name());
        } else {
            logger.info("{} is not enabled", FeatureOptions.UI_COMPONENTS_FEATURE.name());
        }

        boolean vcsFeature = manager.isActive(FeatureOptions.VCS_BRANCHING_FEATURE);
        features.put(FeatureOptions.VCS_BRANCHING_FEATURE.name(), vcsFeature);
        if (vcsFeature) {
            logger.info("{} is enabled", FeatureOptions.VCS_BRANCHING_FEATURE.name());
        } else {
            logger.info("{} is not enabled", FeatureOptions.VCS_BRANCHING_FEATURE.name());
        }

        return features;
    }
}