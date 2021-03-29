package com.example.demotogglz;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum FeatureOptions implements Feature {

    @Label("Publish Feature")
    PUBLISH_FEATURE,
    @Label("Greetings Feature")
    GREETINGS_FEATURE,

    @Label("Vcs branching Feature")
    VCS_BRANCHING_FEATURE,

    @Label("UIComponents Feature")
    UI_COMPONENTS_FEATURE;


    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);

    }
}
