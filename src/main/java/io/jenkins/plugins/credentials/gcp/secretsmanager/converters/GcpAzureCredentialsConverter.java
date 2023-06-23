package io.jenkins.plugins.credentials.gcp.secretsmanager.converters;

import java.util.Map;

import com.cloudbees.plugins.credentials.impl.BaseStandardCredentials;

import io.jenkins.plugins.credentials.gcp.secretsmanager.CredentialsFactory.SecretSupplier;
import io.jenkins.plugins.credentials.gcp.secretsmanager.GcpAzureCredentials;
import io.jenkins.plugins.credentials.gcp.secretsmanager.GcpCredentialsConverter;
import io.jenkins.plugins.credentials.gcp.secretsmanager.GcpStringCredentials;
import io.jenkins.plugins.credentials.gcp.secretsmanager.SecretGetter;
import io.jenkins.plugins.credentials.gcp.secretsmanager.Type;
import org.jenkinsci.plugins.variant.OptionalExtension;

@OptionalExtension(requirePlugins = { "azure-credentials" })
public class GcpAzureCredentialsConverter extends GcpCredentialsConverter {

    @Override
    public boolean canResolve(String type) {
        return Type.AZURE.equals(type);
    }

    @Override
    public BaseStandardCredentials resolve(
            String name, String description, Map<String, String> labels, SecretGetter secretGetter) {
        return new GcpAzureCredentials(name, description, new SecretSupplier(name, secretGetter));
    }
}
