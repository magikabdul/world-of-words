import { createMuiTheme } from '@material-ui/core/styles';

const theme = createMuiTheme({
  palette: {
    primary: {
      light: '#6fbf73',
      main: '#4caf50',
      dark: '#357a38',
      contrastText: '#fff',
    },
    secondary: {
      light: '#834bff',
      main: '#651fff',
      dark: '#4615b2',
      contrastText: '#fff',
    },
  },
});

export default theme;
