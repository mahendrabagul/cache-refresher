package io.github.mahendrabagul.cacherefresher.kubeclient;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.util.Config;
import java.io.IOException;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class KubeClient {

  @Autowired
  private Environment environment;

  public V1PodList getPodsByLabels(String labels) throws IOException, ApiException {
    ApiClient client = Config.fromConfig(Objects.requireNonNull(environment.getProperty("kubeconfig")));
    Configuration.setDefaultApiClient(client);
    CoreV1Api api = new CoreV1Api();
    return api.listPodForAllNamespaces(null, null, null, labels, null, null, null, null, null);
  }
}
