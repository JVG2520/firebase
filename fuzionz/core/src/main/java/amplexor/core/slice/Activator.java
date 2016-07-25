package amplexor.core.slice;

import com.cognifide.slice.api.injector.InjectorRunner;
import com.cognifide.slice.commons.SliceModulesFactory;
import com.cognifide.slice.cq.module.CQModulesFactory;
import com.google.inject.Module;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

import java.util.ArrayList;
import java.util.List;


public class Activator implements BundleActivator {

    public static final String INJECTOR_NAME = "app";

    private static final String BUNDLE_NAME_FILTER = "amplexor.*";

    private static final String BASE_PACKAGE = "amplexor";

    @Override
    public void start(final BundleContext bundleContext) throws BundleException {

        final InjectorRunner injectorRunner = new InjectorRunner(bundleContext, INJECTOR_NAME,
                BUNDLE_NAME_FILTER, BASE_PACKAGE);

        final List<Module> sliceModules = SliceModulesFactory.createModules(bundleContext);
        final List<Module> cqModules = CQModulesFactory.createModules();
        final List<Module> customModules = createCustomModules();

        injectorRunner.installModules(sliceModules);
        injectorRunner.installModules(cqModules);
        injectorRunner.installModules(customModules);

        injectorRunner.start();
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }

    private List<Module> createCustomModules() {
        List<Module> applicationModules = new ArrayList<Module>();
        //populate the list with your modules
        return applicationModules;
    }
}
