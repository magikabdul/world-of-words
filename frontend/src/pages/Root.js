import React, { Component } from 'react';
import { Button, CssBaseline } from '@material-ui/core';

export default class Root extends Component {
  render() {
    return (
      <div>
        <CssBaseline />
        <Button variant='contained' color='primary'>
          Hello World
        </Button>
      </div>
    );
  }
}
