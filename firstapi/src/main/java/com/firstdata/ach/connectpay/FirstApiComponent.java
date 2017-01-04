package com.firstdata.ach.connectpay;

import com.firstdata.ach.connectpay.module.NetworkModule;
import com.firstdata.ach.connectpay.net.FirstApiClient;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Arjun Chinya on 8/25/16.
 */
@Singleton
@Component(modules = NetworkModule.class)
public interface FirstApiComponent {
    FirstApiClient apiClient();
}
