FROM node:12

WORKDIR /app

COPY . .

RUN npm install

RUN npm install bootstrap@4.2.1

RUN npm install http-server -g

RUN npm run build

WORKDIR /app/dist/angular-frontend

RUN ls -la # this is for debuging only

CMD ["http-server", "-c1", "-p", "4200"]

