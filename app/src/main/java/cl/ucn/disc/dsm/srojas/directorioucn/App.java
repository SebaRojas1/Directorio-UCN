package cl.ucn.disc.dsm.srojas.directorioucn;

import android.app.Application;
import android.content.Context;

import org.acra.ACRA;
import org.acra.BuildConfig;
import org.acra.annotation.AcraCore;
import org.acra.config.CoreConfigurationBuilder;
import org.acra.config.DialogConfigurationBuilder;
import org.acra.config.MailSenderConfigurationBuilder;
import org.acra.data.StringFormat;

/**
 * Main App.
 *
 * @author Sebastián Rojas.
 */
@AcraCore(buildConfigClass = BuildConfig.class)
public class App extends Application {

    /**
     * @param base context to use.
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        CoreConfigurationBuilder builder = new CoreConfigurationBuilder(this);
        builder.withBuildConfigClass(BuildConfig.class)
                .withReportFormat(StringFormat.JSON)
                .withEnabled(true);

        // ACRA Dialog configuration
        builder.getPluginConfigurationBuilder(DialogConfigurationBuilder.class)
                .withResText(R.string.acra_dialog_title)
                .withResCommentPrompt(R.string.acra_dialog_comment)
                .withEnabled(true);

        // ACRA Email configuration
        builder.getPluginConfigurationBuilder(MailSenderConfigurationBuilder.class)
                .withMailTo("sebastian.rojas04@alumnos.ucn.cl")
                .withReportAsFile("crash.txt")
                .withSubject(getString(R.string.acra_dialog_title))
                .withBody(getString(R.string.acra_dialog_comment))
                .withEnabled(true);


        // The following line triggers the initialization of ACRA
        ACRA.init(this);
    }
}
