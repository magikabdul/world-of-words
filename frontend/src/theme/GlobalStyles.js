import { createGlobalStyle } from 'styled-components';

import backgroundImage from '../assets/images/book.jpg';

const WelcomeGlobalStyles = createGlobalStyle`
  html{
    height: 100vh;
  }
  
  body {
    background-image: url(${backgroundImage});
    background-position: center;
    background-size: cover;
    background-repeat: no-repeat;
  }
`;

export default WelcomeGlobalStyles;
