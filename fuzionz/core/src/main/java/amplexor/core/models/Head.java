package amplexor.core.models;

import com.adobe.cq.sightly.WCMUse;
import com.cognifide.slice.mapper.annotation.SliceResource;
import com.day.cq.wcm.commons.WCMUtils;
import com.google.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

@SliceResource
public class Head extends WCMUse {
    private ResourceResolver resourceResolver;
    private String keywords;
    private Resource favIcon;

    @Inject
    public Head(ResourceResolver resourceResolver) {
        this.resourceResolver = resourceResolver;
    }

    @Override
    public void activate() throws Exception {
        keywords = WCMUtils.getKeywords(getCurrentPage(), false);
        favIcon = getResourceResolver().getResource(getCurrentDesign().getPath() + "/favicon.ico");
    }

    public String getKeywords() {
        return keywords;
    }

    public Resource getFavIcon() {
        return favIcon;
    }
}
