import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';

import { Button } from '@material-ui/core';
import LockOpenIcon from '@material-ui/icons/LockOpen';

import { routes } from '../../routes';
import logo from '../../assets/images/words_icon.png';

const Wrapper = styled.div`
  width: 100%;
  height: 80px;

  display: flex;
  justify-content: center;
  align-items: center;

  background-color: rgba(155, 155, 155, 0.3);
  box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.2);
`;

const Logo = styled.div`
  margin-left: 50px;

  width: 60px;
  height: 60px;

  background-image: url(${logo});
  background-position: center;
  background-size: cover;
`;

const ButtonContainer = styled.div`
  margin-right: 50px;
  flex: 1;

  display: flex;
  justify-content: flex-end;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
`;

export const WelcomeHeader = () => {
  return (
    <Wrapper>
      <Logo />
      <ButtonContainer>
        <StyledLink to={routes.login}>
          <Button
            color='primary'
            variant='outlined'
            startIcon={<LockOpenIcon />}
          >
            login
          </Button>
        </StyledLink>
      </ButtonContainer>
    </Wrapper>
  );
};
