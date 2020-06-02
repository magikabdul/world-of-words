import React, { Component } from 'react';
import { CssBaseline } from '@material-ui/core';
import { ThemeProvider } from '@material-ui/styles';
import { BrowserRouter, Switch, Route } from 'react-router-dom';

import { routes } from '../routes';
import theme from '../theme/theme';

import GlobalStyles from '../theme/GlobalStyles';
import WelcomePage from '../pages/WelcomePage';
import ErrorPage from '../pages/ErrorPage';
import LoginPage from '../pages/LoginPage';
import RegisterPage from '../pages/RegisterPage';

export default class Root extends Component {
  render() {
    return (
      <BrowserRouter>
        <CssBaseline />
        <GlobalStyles />
        <ThemeProvider theme={theme}>
          <Switch>
            <Route exact path={routes.home} component={WelcomePage} />
            <Route exact path={routes.login} component={LoginPage} />
            <Route exact path={routes.register} component={RegisterPage} />
            <Route component={ErrorPage} />
          </Switch>
        </ThemeProvider>
      </BrowserRouter>
    );
  }
}
