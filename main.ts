declare module '@angular/platform-browser' {
  export function bootstrapApplication(rootComponent: any, config?: any): Promise<any>;
}

// @ts-ignore
import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';

bootstrapApplication(App, appConfig)
  .catch((err: unknown) => console.error(err));
