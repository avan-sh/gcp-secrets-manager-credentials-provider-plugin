package io.jenkins.plugins.credentials.gcp.secretsmanager.converters;

import java.util.Map;

import com.cloudbees.plugins.credentials.impl.BaseStandardCredentials;
import io.jenkins.plugins.credentials.gcp.secretsmanager.CredentialsFactory.SecretSupplier;
import hudson.Extension;
import io.jenkins.plugins.credentials.gcp.secretsmanager.GcpCredentialsConverter;
import io.jenkins.plugins.credentials.gcp.secretsmanager.SecretGetter;
import io.jenkins.plugins.credentials.gcp.secretsmanager.GcpJsonUsernamePasswordCredentials;
import io.jenkins.plugins.credentials.gcp.secretsmanager.GcpUsernamePasswordCredentials; // TODO: REMOVE

@Extension
public class GcpJsonUsernamePasswordCredentialsConverter extends GcpCredentialsConverter {

    @Override
    public boolean canResolve(String type) {
        return "json-username-password".equals(type);
    }

    @Override
    public BaseStandardCredentials resolve(
            String name, String description, Map<String, String> labels, SecretGetter secretGetter) {

        return new GcpJsonUsernamePasswordCredentials(
                name, description, new SecretSupplier(name, secretGetter));
    }

}
