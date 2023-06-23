package io.jenkins.plugins.credentials.gcp.secretsmanager;

import com.azure.core.management.AzureEnvironment;
import com.cloudbees.plugins.credentials.CredentialsScope;
import com.cloudbees.plugins.credentials.impl.BaseStandardCredentials;
import java.util.function.Supplier;

import hudson.util.Secret;
// import io.jenkins.plugins.credentials.gcp.secretsmanager.CredentialsFactory.SecretSupplier;
import com.microsoft.azure.util.AzureBaseCredentials;

public class GcpAzureCredentials extends AzureBaseCredentials {

    public GcpAzureCredentials(CredentialsScope scope, String id, String description) {
        super(scope, id, description);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String getAzureEnvironmentName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAzureEnvironmentName'");
    }

    @Override
    public String getManagementEndpoint() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getManagementEndpoint'");
    }

    @Override
    public String getActiveDirectoryEndpoint() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActiveDirectoryEndpoint'");
    }

    @Override
    public String getResourceManagerEndpoint() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResourceManagerEndpoint'");
    }

    @Override
    public String getGraphEndpoint() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGraphEndpoint'");
    }

    @Override
    public String getSubscriptionId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSubscriptionId'");
    }

    @Override
    public AzureEnvironment getAzureEnvironment() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAzureEnvironment'");
    }

}
