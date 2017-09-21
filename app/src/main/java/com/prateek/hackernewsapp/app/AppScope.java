package com.prateek.hackernewsapp.app;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Named;
import javax.inject.Scope;

/**
 * Created by prateek on 21/9/17.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface AppScope {
}
