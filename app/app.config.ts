import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient, withInterceptors } from '@angular/common/http';
import { routes } from './app.routes';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

const authInterceptor = (req: any, next: any) => {
  const cloned = req.clone({ setHeaders: { Authorization: 'Bearer mock-token-12345' } });
  return next.handle(cloned);
};

const errorHandlerInterceptor = (req: any, next: any) => {
  return next.handle(req).pipe(
    catchError((error: any) => {
      console.error('HTTP error', error);
      return throwError(() => new Error('Failed to load data.'));
    })
  );
};

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideHttpClient(withInterceptors([authInterceptor, errorHandlerInterceptor]))
  ]
};
