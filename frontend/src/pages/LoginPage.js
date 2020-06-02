import React from 'react';
import styled from 'styled-components';
import { Button, TextField, Typography } from '@material-ui/core';
import { Link } from 'react-router-dom';
import CancelIcon from '@material-ui/icons/Cancel';

import ImageLaptop from '../assets/images/laptop.jpg';
import { routes } from '../routes';

const Wrapper = styled.div`
  height: 100vh;

  background-color: #ebeeef;

  display: flex;
  justify-content: center;
  align-items: center;

  position: relative;
`;

const Close = styled(Link)`
  width: 24px;
  height: 24px;

  position: absolute;
  top: 10px;
  right: 10px;
  color: whitesmoke;
`;

const Container = styled.div`
  background-color: white;

  height: 50%;
  width: 50%;
  max-width: 600px;

  border-radius: 10px;
  overflow: hidden;
`;

const Header = styled.div`
  position: relative;
  height: 40%;

  background-image: url(${ImageLaptop});
  background-position: center;
`;

const HeaderBackground = styled.div`
  width: 100%;
  height: 100%;

  background-color: rgba(0, 0, 0, 0.4);
  color: white;

  display: flex;
  justify-content: center;
  align-items: center;
`;

const HeaderTitle = styled.div`
  font-size: 32px;
  font-weight: 700;
`;

const Form = styled.form`
  margin: 5px 80px;
`;

const ButtonContainer = styled.div`
  margin: 20px auto;
  width: 40%;
`;

const StyledLink = styled(Link)`
  text-decoration: none;
`;

const LoginPage = () => {
  return (
    <Wrapper>
      <Container>
        <Header>
          <Close to={routes.home}>
            <CancelIcon />
          </Close>
          <HeaderBackground>
            <HeaderTitle>SIGN IN</HeaderTitle>
          </HeaderBackground>
        </Header>
        <Form>
          <TextField
            color='secondary'
            fullWidth
            label='Username / Email address'
            margin='normal'
            required
          />
          <TextField
            type='password'
            color='secondary'
            fullWidth
            label='Password'
            margin='normal'
            required
          />
          <ButtonContainer>
            <Button
              variant='contained'
              color='secondary'
              size='large'
              fullWidth
              type='submit'
            >
              LOGIN
            </Button>
          </ButtonContainer>
        </Form>
        <Typography align='center' color='textSecondary' variant='subtitle2'>
          Don't have an account -{' '}
          <StyledLink to={routes.register}>Register</StyledLink>
        </Typography>
      </Container>
    </Wrapper>
  );
};

export default LoginPage;
