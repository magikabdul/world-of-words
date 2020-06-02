import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';

import { Button } from '@material-ui/core';

import { routes } from '../routes';

import { WelcomeHeader } from '../components';

const Wrapper = styled.div`
  margin-left: 10%;
  margin-top: 200px;

  min-width: 450px;
  width: 40%;
`;

const Title = styled.div`
  font-weight: 700;
  font-size: 42px;
  color: white;
`;

const Info = styled.p`
  color: white;
  margin-bottom: 30px;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
`;

const WelcomePage = () => {
  return (
    <>
      <WelcomeHeader />
      <Wrapper>
        <Title>IMPROVE YOUR</Title>
        <Title>KNOWLEDGE OF WORDS</Title>
        <Info>Your way to expand your knowledge</Info>
        <StyledLink to={routes.register}>
          <Button color='primary' variant='contained'>
            GET STARTED
          </Button>
        </StyledLink>
      </Wrapper>
    </>
  );
};

export default WelcomePage;
